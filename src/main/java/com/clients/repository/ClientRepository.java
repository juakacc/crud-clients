package com.clients.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clients.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query(
		value = "SELECT * FROM client c WHERE c.nome LIKE %:nome% OR c.cpf LIKE %:cpf%", 
		nativeQuery = true)
	Page<Client> search(@Param("nome") String nome, @Param("cpf") String cpf, Pageable pageable);
	
}
