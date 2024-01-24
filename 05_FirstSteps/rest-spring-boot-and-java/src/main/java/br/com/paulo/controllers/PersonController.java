package br.com.paulo.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return service.findAll();
		}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById (@PathVariable (value = "id") Long id) throws Exception{
		
		return service.findById(id);	
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create (@RequestBody Person person){
		
		return service.create(person);	
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update (@RequestBody Person person){
		
		return service.update(person);
	}

	
	@DeleteMapping(value = "/{id}")
	public void delete (@PathVariable (value = "id") Long id){
		
		service.delete(id);	
	}
}
