package dev.lab.demo.repository;

import dev.lab.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.emailAddress=?1")
    Client findClientByEmail(String emailAddress);

}
