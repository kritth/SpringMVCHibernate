package common.dao;

import common.model.ExampleModel;

public interface ExampleDAO {
	void insert(ExampleModel em);
	ExampleModel getById(int id);
}
