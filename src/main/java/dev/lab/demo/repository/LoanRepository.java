package dev.lab.demo.repository;

import dev.lab.demo.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select l from Loan l where l.loanNumber=?1 and l.loanSuffix=?2")
    Loan findLoanByLoanRef(String loanNumber, String loanSuffix);

}
