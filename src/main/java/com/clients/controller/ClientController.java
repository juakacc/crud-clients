package com.clients.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clients.dto.ClientDTO;
import com.clients.model.Client;
import com.clients.repository.ClientRepository;
import com.clients.service.ClientService;

@RestController
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ClientService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> list(
			@RequestParam(required = false) String cpf,
			@RequestParam(required = false) String nome,			
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "5") int size) {
		
		List<Client> clients = service.listClients(nome, cpf, page, size);
		return ResponseEntity.ok(this.toCollectionModel(clients));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
		Optional<Client> client = repository.findById(id);
		
		if (client.isPresent()) {
			return ResponseEntity.ok(this.toModel(client.get()));
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
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody @Valid Client client) {
		Client clientUpdated = service.updateClient(id, client);
		
		if (clientUpdated == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(this.toModel(clientUpdated));		
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ClientDTO> updatePartial(@PathVariable Long id, @RequestBody Client params) {
		Client clientUpdated = service.updatePartialClient(id, params);
		
		if (clientUpdated == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(this.toModel(clientUpdated));
	}
	
	private ClientDTO toModel(Client client) {
		return modelMapper.map(client, ClientDTO.class);
	}
	
	private List<ClientDTO> toCollectionModel(List<Client> list) {
		return list.stream().map(client -> this.toModel(client)).collect(Collectors.toList());
	}
}
