package com.clients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clients.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	public List<Client> findByCpf(String cpf);
	public List<Client> findByNome(String nome);
}
