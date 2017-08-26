package common.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.model.ExampleModel;

@Repository
public class ExampleDAOImpl implements ExampleDAO {
	/* Session Factory set up */
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ExampleDAOImpl.class);
	
	/* Override methods */
	
	@Override
	public void insert(ExampleModel em) {
		getSession().persist(em);
		logger.info("Model is saved successfully");
	}

	@Override
	public ExampleModel getById(int id) {
		ExampleModel result = (ExampleModel) getSession().load(ExampleModel.class, id);
		Hibernate.initialize(result);
		logger.info("Model is fetched successfully");
		return result;
	}

}
