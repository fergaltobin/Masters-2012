package doconnor.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import doconnor.jpa.domain.Company;
import doconnor.jpa.domain.Sponsorship;

@Repository
public class CompanyDAOImpl extends HibernateDAO implements CompanyDAO {

	@Override
	public void reattach(Company company) {
		 getEntityManager().merge(company) ;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Company> getAll() {
		return  getEntityManager().createQuery("from Company").
					getResultList();
	}

	@Override
	public void save(Company c) {
		getEntityManager().persist(c) ;
	}

	@Override
	public void save(Sponsorship s) {
		getEntityManager().persist(s) ;
	}

}
