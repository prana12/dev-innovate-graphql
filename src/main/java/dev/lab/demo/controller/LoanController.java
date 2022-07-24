package dev.lab.demo.controller;

import dev.lab.demo.constant.LoanStatus;
import dev.lab.demo.model.Client;
import dev.lab.demo.model.Loan;
import dev.lab.demo.repository.ClientRepository;
import dev.lab.demo.repository.LoanRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LoanController {

    private LoanRepository loanRepository;
    private ClientRepository clientRepository;

    public LoanController(LoanRepository loanRepository, ClientRepository clientRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
    }

    @QueryMapping
    public List<Loan> allLoans() {
        return loanRepository.findAll();
    }

    @SchemaMapping(typeName="Loan", field="client")
    public Client getClient(Loan loan) {
        return clientRepository.findById(loan.getClient().getId()).orElseThrow(null);
    }

    @QueryMapping
    public Loan findLoan(@Argument String loanNumber, @Argument String loanSuffix) {
        return  loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);
    }

    @MutationMapping
    public Loan createLoan(@Argument String loanNumber, @Argument String loanSuffix, @Argument LoanStatus loanStatus, @Argument Long clientId) {
        Client client = clientRepository.getById(clientId);

        Loan loan = new Loan();
        loan.setLoanNumber(loanNumber);
        loan.setLoanSuffix(loanSuffix);
        loan.setLoanStatus(loanStatus);
        loan.setClient(client);
        return loanRepository.save(loan);
    }

}
