package dev.lab.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInput {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String emailAddress;
    private String addressLine1;
    private String postcode;
}
