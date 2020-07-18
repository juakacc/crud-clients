package com.clients.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getById(@PathVariable Long id) {
		Optional<Client> client = repository.findById(id);
		
		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
		System.out.println("Cliente válido");
		return null;
//		Client clientSaved = repository.save(client);
//		return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
	}
	
}
