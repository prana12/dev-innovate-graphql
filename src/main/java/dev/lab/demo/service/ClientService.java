package dev.lab.demo.service;

import dev.lab.demo.model.Client;
import dev.lab.demo.model.ClientInput;
import dev.lab.demo.model.Loan;
import dev.lab.demo.repository.ClientRepository;
import dev.lab.demo.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {

    private LoanRepository loanRepository;
    private ClientRepository clientRepository;

    public ClientService(LoanRepository loanRepository, ClientRepository clientRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
    }

    public List<Client> allClients() {
        return clientRepository.findAll();
    }

    public Client findClient(String emailAddress) {
        return clientRepository.findClientByEmail(emailAddress);
    }

    public Client createClient(ClientInput clientInput) {
        Client client = new Client();
        client.setFirstName(clientInput.getFirstName());
        client.setLastName(clientInput.getLastName());
        client.setEmailAddress(clientInput.getEmailAddress());
        client.setDateOfBirth(LocalDate.parse(clientInput.getDateOfBirth()));
        client.setAddressLine1(clientInput.getAddressLine1());
        client.setPostcode(clientInput.getPostcode());
        clientRepository.save(client);

        return client;
    }

    public Client deleteClient(String emailAddress) {
        Client client = clientRepository.findClientByEmail(emailAddress);
        loanRepository.deleteLoansByClientId(client.getId());
        clientRepository.delete(client);

        return client;
    }

    //LoanResolver - Client object
    public Client getClient(Loan loan) {
        return clientRepository.findById(loan.getClient().getId()).orElseThrow(null);
    }

}
