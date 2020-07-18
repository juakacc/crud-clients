package com.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clients.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
