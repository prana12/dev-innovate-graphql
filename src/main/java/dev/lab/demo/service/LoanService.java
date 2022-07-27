package dev.lab.demo.service;

import dev.lab.demo.model.Client;
import dev.lab.demo.model.Loan;
import dev.lab.demo.model.LoanInput;
import dev.lab.demo.repository.ClientRepository;
import dev.lab.demo.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private LoanRepository loanRepository;
    private ClientRepository clientRepository;

    public List<Loan> allLoans() {
        return loanRepository.findAll();
    }

    public Loan findLoan(String loanNumber, String loanSuffix) {
        return loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);
    }

    public Loan createLoan(LoanInput loanInput) {
        Client client = clientRepository.getById(loanInput.getClientId());
        Loan loan = Loan.builder()
                .loanNumber(loanInput.getLoanNumber())
                .loanSuffix(loanInput.getLoanSuffix())
                .loanStatus(loanInput.getLoanStatus())
                .client(client)
                .build();
        return loanRepository.save(loan);
    }

    public Loan deleteLoan(String loanNumber, String loanSuffix) {
        Loan loan = loanRepository.findLoanByLoanRef(loanNumber, loanSuffix);
        loanRepository.delete(loan);

        return loan;
    }

}
