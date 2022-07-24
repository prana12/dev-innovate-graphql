package dev.lab.demo.controller;

import dev.lab.demo.model.Client;
import dev.lab.demo.repository.ClientRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientController {
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @QueryMapping
    public List<Client> allClients() {
        return clientRepository.findAll();
    }
}
