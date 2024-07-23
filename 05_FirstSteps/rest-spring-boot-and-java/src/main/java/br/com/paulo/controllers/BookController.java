package br.com.paulo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulo.data.vo.v1.BookVO;
import br.com.paulo.services.BookServices;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	//Find All
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookVO> findAll() {
		return service.findAll();
	}
	
	//Find by ID
	@GetMapping(value = "/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public BookVO findById(@PathVariable(value = "id") Long id) {
		return service.findbyId(id);
	}
	
	//Create
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}
	
	//Update
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}
	
	//Delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
