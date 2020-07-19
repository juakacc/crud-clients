package com.clients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.clients.model.Client;
import com.clients.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Client updateClient(Long id, Client client) {
		if (!repository.existsById(id)) {
			return null;
		}
		client.setId(id);
		return repository.save(client);
	}

	public List<Client> listClients(String nome, String cpf, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Order.asc("nome")));
		
		if (nome != null || cpf != null)
			return repository.search(nome, cpf, pageable).getContent();
		else 
			return repository.findAll(pageable).getContent();
	}
	
	public Client updatePartialClient(Long id, Client params) {
		
		if (!repository.existsById(id)) {
			return null;
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
		return repository.save(client);
	}
}
