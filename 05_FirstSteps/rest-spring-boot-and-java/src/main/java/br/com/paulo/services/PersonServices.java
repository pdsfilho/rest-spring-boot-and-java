package br.com.paulo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.paulo.models.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Paulo");
		person.setLastName("Dantas");
		person.setAddress("Recife - Pernambuco - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	public List<Person> findAll() {
		
		logger.info("Finding all people.");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i< 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brazil "+  i);
		person.setGender("Male");
		
		return person;
	}
	
}