package br.com.paulo.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulo.models.Person;
import br.com.paulo.services.PersonServices;


@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	//private PersonServices = new PersonServices();
	
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return service.findAll();
		}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById (@PathVariable (value = "id") String id) throws Exception{
		
		return service.findById(id);	
	}
	
}