package common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import common.model.ExampleModel;
import common.service.ExampleService;

@Controller
public class ExampleController {
	// Autowired candidate has to always be interface object
	private ExampleService service;
	
	public void setService(ExampleService service) {
		this.service = service;
	}
	
	// Making default servlet and attach object to it
	@RequestMapping(value = "/")
	public String startApp(Model model) {
		// Add new object to the model to pass to spring form
		model.addAttribute("newModel", new ExampleModel());
		// Forward it to index page. Notice that we do not have any prefix or suffix because
		// it is handled by spring we defined in the xml
		return "index";
	}
	
	// Getting request with regular form through post
	@RequestMapping(value = "/model/insert/", method = RequestMethod.POST)
	public String insertModel(
			@RequestParam("val") String val) {
		// Create new object and set value. Note that id is not needed because
		// we auto generate it
		ExampleModel obj = new ExampleModel();
		obj.setVal(val);
		
		// Insert into db
		service.insert(obj);
		
		// return to index
		return "redirect:/";
	}
	
	// Getting request with spring form through post
	@RequestMapping(value = "/model/insert/spring", method = RequestMethod.POST)
	public String insertSpringModel(
			@ModelAttribute("new_model") ExampleModel obj) {
		// Insert into db
		service.insert(obj);
		
		// return to index
		return "redirect:/";
	}
	
	// Using path variable to get model through get
	@RequestMapping(value = "/model/get/{id}", method = RequestMethod.GET)
	public String getModelById(
			@PathVariable("id") int id,
			Model model) {
		// Get object
		ExampleModel obj = service.getById(id);
		
		// attach object
		model.addAttribute("model", obj);
		model.addAttribute("newModel", new ExampleModel());
		
		// return to index
		return "index";
	}
}