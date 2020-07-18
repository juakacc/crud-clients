package com.clients.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Client clientSaved = repository.save(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody @Valid Client client) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		client.setId(id);
		repository.save(client);

		return ResponseEntity.ok(repository.findById(id).get());
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Client> updatePartial(@PathVariable Long id, @RequestBody Client params) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		Client client = repository.findById(id).get();
		
		if (params.getNome() != null && params.getNome().trim().length() > 0) {
			client.setNome(params.getNome());
		}
		
		if (params.getCpf() != null && params.getCpf().trim().length() == 11) {
			client.setCpf(params.getCpf());
		}
		
		if (params.getDataNascimento() != null) {
			client.setDataNascimento(params.getDataNascimento());
		}
		repository.save(client);
		return ResponseEntity.ok(repository.findById(id).get());
	}
}
