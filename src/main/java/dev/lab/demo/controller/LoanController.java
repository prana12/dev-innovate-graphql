package dev.lab.demo.controller;

import dev.lab.demo.model.Client;
import dev.lab.demo.model.Loan;
import dev.lab.demo.model.LoanInput;
import dev.lab.demo.service.ClientService;
import dev.lab.demo.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class LoanController {
    private LoanService loanService;
    private ClientService clientService;

    @QueryMapping
    public List<Loan> allLoans() {
        return loanService.allLoans();
    }

    //may work without this for Resolver - implements GraphQLResolver<Loan>
    @SchemaMapping(typeName="Loan", field="client")
    public Client getClient(Loan loan) {
        return clientService.getClient(loan);
    }

    @QueryMapping
    public Loan findLoan(@Argument String loanNumber, @Argument String loanSuffix) {
        return loanService.findLoan(loanNumber, loanSuffix);
    }

    @MutationMapping
    public Loan createLoan(@Argument LoanInput loanInput) {
        return loanService.createLoan(loanInput);
    }

    @MutationMapping
    public Loan deleteLoan(@Argument String loanNumber, @Argument String loanSuffix) {
        return loanService.deleteLoan(loanNumber, loanSuffix);
    }

}
