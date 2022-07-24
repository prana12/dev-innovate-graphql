package dev.lab.demo.controller;

import dev.lab.demo.model.Client;
import dev.lab.demo.repository.ClientRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
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

    @QueryMapping
    public Client findClient(@Argument String emailAddress) {
        return clientRepository.findClientByEmail(emailAddress);
    }

    @MutationMapping
    public Client createClient(@Argument String firstName, @Argument String lastName, @Argument String emailAddress, @Argument String dateOfBirth, @Argument String addressLine1, @Argument String postcode) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmailAddress(emailAddress);
        client.setDateOfBirth(LocalDate.parse(dateOfBirth));
        client.setAddressLine1(addressLine1);
        client.setPostcode(postcode);
        clientRepository.save(client);

        return client;
    }

    @MutationMapping
    public Client deleteClient(@Argument String emailAddress) {
        Client client = clientRepository.findClientByEmail(emailAddress);
        clientRepository.delete(client);

        return client;
    }
}
