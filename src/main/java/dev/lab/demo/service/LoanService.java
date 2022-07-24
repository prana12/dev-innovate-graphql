package dev.lab.demo.service;

import dev.lab.demo.model.Client;
import dev.lab.demo.model.Loan;
import dev.lab.demo.model.LoanInput;
import dev.lab.demo.repository.ClientRepository;
import dev.lab.demo.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private LoanRepository loanRepository;
    private ClientRepository clientRepository;

    public LoanService(LoanRepository loanRepository, ClientRepository clientRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
    }

    public List<Loan> allLoans() {
        return loanRepository.findAll();
    }

    public Loan findLoan(String loanNumber, String loanSuffix) {
        return loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);
    }

    public Loan createLoan(LoanInput loanInput) {
        Client client = clientRepository.getById(loanInput.getClientId());

        Loan loan = new Loan();
        loan.setLoanNumber(loanInput.getLoanNumber());
        loan.setLoanSuffix(loanInput.getLoanSuffix());
        loan.setLoanStatus(loanInput.getLoanStatus());
        loan.setClient(client);
        return loanRepository.save(loan);
    }

    public Loan deleteLoan(String loanNumber, String loanSuffix) {
        Loan loan = loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);
        loanRepository.delete(loan);

        return loan;
    }

}
