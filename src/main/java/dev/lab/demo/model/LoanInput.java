package dev.lab.demo.model;

import dev.lab.demo.constant.LoanStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanInput {
    private String loanNumber;
    private String loanSuffix;
    private LoanStatus loanStatus;
    private Long clientId;
}
