package dev.lab.demo.repository;

import dev.lab.demo.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select l from Loan l where l.loanNumber=?1 and l.loanSuffix=?2")
    Loan findLoanByLoanRef(String loanNumber, String loanSuffix);

    @Transactional
    @Modifying
    @Query("delete Loan l where l.client.id = ?1")
    void deleteLoansByClientId(Long clientId);

}
