package dev.lab.demo.controller;

import dev.lab.demo.constant.LoanStatus;
import dev.lab.demo.model.Loan;
import dev.lab.demo.repository.LoanRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LoanController {

    private LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @QueryMapping
    public List<Loan> allLoans() {
        return loanRepository.findAll();
    }

    @QueryMapping
    public Loan findLoan(@Argument String loanNumber, @Argument String loanSuffix) {
        return  loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);
    }

    @MutationMapping
    public Loan createLoan(@Argument String loanNumber, @Argument String loanSuffix, @Argument LoanStatus loanStatus) {
        Loan loan = new Loan();
        loan.setLoanNumber(loanNumber);
        loan.setLoanSuffix(loanSuffix);
        loan.setLoanStatus(loanStatus);
        return loanRepository.save(loan);
    }

}
