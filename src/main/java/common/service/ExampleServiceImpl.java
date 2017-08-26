package common.service;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.ExampleDAO;
import common.model.ExampleModel;

@Service
public class ExampleServiceImpl implements ExampleService {
	// Autowired candidate has to always be interface object
	@Autowired
	private ExampleDAO dao;
	
	public void setDao(ExampleDAO dao) {
		this.dao = dao;
	}

	/* Override methods */
	@Override
	@Transactional
	public void insert(ExampleModel em) {
		// Example condition usage
		if (em != null) {
			this.dao.insert(em);
		}
	}

	@Override
	@Transactional
	public ExampleModel getById(int id) {
		// Example condition usage
		if (id >= 0) {
			try {
				return this.dao.getById(id);
			} catch (ObjectNotFoundException ex) {
				System.err.println("Error: Object not found in the database");
			}
		}
		
		// not finding anything
		return null;
	}
}
