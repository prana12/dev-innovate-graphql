package dev.lab.demo.controller;

import dev.lab.demo.model.Loan;
import dev.lab.demo.repository.LoanRepository;
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
    public Loan findLoan(String loanNumber, String loanSuffix) {
        //return loanRepository.findById(id).get();
        //return  loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);

        Loan loan = new Loan();
        loan.setLoanNumber("123456");
        loan.setLoanSuffix("00");
        loan.setLoanStatus("TEST-Find-Query");
        return loan;
    }

    @MutationMapping
    public Loan createLoan(String loanNumber, String loanSuffix, String loanStatus) {
        Loan loan = new Loan();
        loan.setLoanNumber("123456");
        loan.setLoanSuffix("00");
        loan.setLoanStatus("TEST-Mutation");
        return loan;
    }

}
