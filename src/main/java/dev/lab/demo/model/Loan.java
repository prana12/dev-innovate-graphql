package dev.lab.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String loanNumber;
    private String loanSuffix;
    private String loanStatus;

    public Loan() { }

    /*public Loan(String loanNumber, String loanSuffix, String loanStatus) {
        this.loanNumber = loanNumber;
        this.loanSuffix = loanSuffix;
        this.loanStatus = loanStatus;
    }*/

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

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}
