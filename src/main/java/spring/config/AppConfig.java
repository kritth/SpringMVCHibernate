package spring.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import common.controller.ExampleController;
import common.dao.ExampleDAO;
import common.dao.ExampleDAOImpl;
import common.service.ExampleService;
import common.service.ExampleServiceImpl;

// Configuration class for spring
@EnableWebMvc
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	// Create view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
	}
	
	// MVC Mapping
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	// Create dao bean
	@Bean
	@Autowired
	public ExampleDAO createDao(SessionFactory sf) {
		ExampleDAO dao = new ExampleDAOImpl();
		((ExampleDAOImpl) dao).setSessionFactory(sf);
		return dao;
	}
	
	// Create service bean
	@Bean
	@Autowired
	public ExampleService createService(ExampleDAO dao) {
		ExampleService service = new ExampleServiceImpl();
		((ExampleServiceImpl) service).setDao(dao);
		return service;
	}
	
	// Create controller bean
	@Bean
	@Autowired
	public ExampleController createController(ExampleService service) {
		ExampleController controller = new ExampleController();
		controller.setService(service);
		return controller;
	}
}
