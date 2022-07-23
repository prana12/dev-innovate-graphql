package dev.lab.demo.model;

import dev.lab.demo.constant.LoanStatus;

import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanNumber;
    private String loanSuffix;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    public Loan() { }

    public Long getId() {
        return id;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanSuffix() {
        return loanSuffix;
    }

    public void setLoanSuffix(String loanSuffix) {
        this.loanSuffix = loanSuffix;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
