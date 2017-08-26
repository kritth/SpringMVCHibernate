package common.service;

import common.model.ExampleModel;

public interface ExampleService {
	void insert(ExampleModel em);
	ExampleModel getById(int id);
}
