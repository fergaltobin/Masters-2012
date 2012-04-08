package doconnor.jpa.view.commands;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import doconnor.jpa.domain.Company;
import doconnor.jpa.domain.Product;
import doconnor.jpa.service.LeagueManager;
@Component
public class AddProduct extends AbstractCommand implements Command {
	@Autowired
	public AddProduct(LeagueManager leagueService, Scanner scanner) {
		super(leagueService, scanner);
	}

	@Override
	public void execute() {
		System.out.print("Product Name?");
	    String name = scanner.next();
		Product player = new Product(name);
		Company com = getCompany();
		leagueService.createProduct(player, com);
 	}

	@Override
	public String help() {
		return "create a new product that can use for licensing with players";
	}

}
