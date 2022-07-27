package dev.lab.demo.controller;

import dev.lab.demo.model.Client;
import dev.lab.demo.model.ClientInput;
import dev.lab.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @QueryMapping
    public List<Client> allClients() {
        return clientService.allClients();
    }

    @QueryMapping
    public Client findClient(@Argument String emailAddress) {
        return clientService.findClient(emailAddress);
    }

    @MutationMapping
    public Client createClient(@Argument ClientInput clientInput) {
        return clientService.createClient(clientInput);
    }

    @MutationMapping
    public Client deleteClient(@Argument String emailAddress) {
        return clientService.deleteClient(emailAddress);
    }
}
