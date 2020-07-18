package com.clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clients.model.Client;
import com.clients.repository.ClientRepository;

@RestController
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Client>> list() {
		return ResponseEntity.ok(repository.findAll());
	}
}
