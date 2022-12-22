package br.com.analuizapoc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {

    PC001("PC-001", "Invalid Request."),
    PC101("PC-101", "This customer does not exists."),
    PC102("PC-102", "Invalid  person type given. Valid values are [PJ, PF], please insert one of them."),
    PC201("PC-201", "This address does not exists."),
    PC202("PC-202", "Invalid zipcode given. Please, give a valid zipcode"),
    PC203("PC-203", "Limit os this customer address reached"),
    PC204("PC-204", "You must have at least one main address");

    private final String code;
    private final String message;
}
