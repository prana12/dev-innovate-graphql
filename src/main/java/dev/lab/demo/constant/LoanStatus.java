package dev.lab.demo.constant;

public enum LoanStatus {
    ACTIVE("Active"),
    CANCELLED("Cancelled"),
    REJECTED("Rejected"),
    CLOSED("Closed");

    private String desc;

    LoanStatus(String desc) {
        this.desc = desc;
    }

}
