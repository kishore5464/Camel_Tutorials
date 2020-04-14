package com.kishore.controller;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.model.Books;

@RestController
public class MyController {

	@Autowired
	private ProducerTemplate producerTemplate;

	@PostMapping(value = "/addBook")
	public boolean insertBook(@RequestBody Books book) {
		producerTemplate.requestBody("direct:insert", book, List.class);
		return true;
	}

	@GetMapping(value = "/books")
	public List<Books> getAllBooks() {
		@SuppressWarnings("unchecked")
		List<Books> books = producerTemplate.requestBody("direct:select", null, List.class);
		return books;
	}
}
