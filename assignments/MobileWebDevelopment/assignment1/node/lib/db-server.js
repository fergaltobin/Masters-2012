var common = require('./common')
var api = require('./db-rest-api')

var connect = common.connect

function init() {
	var server = connect.createServer()
	server.use(connect.logger())
	server.use(connect.bodyParser())
	server.use(connect.query())

	server.use(function(req, res, next) {
		res.sendjson$ = function(obj) {
			common.sendjson(res, obj)
		}
		res.send$ = function(code, text) {
			res.writeHead(code, '' + text)
			res.end()
		}
		res.err$ = function(win) {
			return function(err, output) {
				if(err) {
					console.log(err)
					res.send$(500, err)
				} else {
					win && win(output)
				}
			}
		}
		next()
	})
	var router = connect.router(function(app) {
		app.get('/api/ping', api.ping)
		app.get('/api/echo', api.echo)
		app.post('/api/echo', api.echo)
		app.post('/api/rest/todo', api.rest.create)
		app.get('/api/rest/todo/:id', api.rest.read)
		app.get('/api/rest/login/:id', api.rest.readlogin)
		app.get('/api/rest/login', api.rest.readlogin)
		app.get('/api/rest/todo', api.rest.list)
		app.put('/api/rest/todo/:id', api.rest.update)
		app.del('/api/rest/todo/:id', api.rest.del)

	})
	server.use(router, null)

	server.use(connect.static(__dirname + '/../../site/public'))

	api.connect({
		name : 'todolist',
		server : 'services.dreeling.com',
		port : 27017
	}, function(err) {
		if(err)
			return console.log(err);

		server.listen(8180)
	})
}

init()