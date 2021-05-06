package org.cap.account.repository;

import org.cap.account.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClientRestApiRepo extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.clientId= :clientId")
    Client findClientById(Long clientId);
}
