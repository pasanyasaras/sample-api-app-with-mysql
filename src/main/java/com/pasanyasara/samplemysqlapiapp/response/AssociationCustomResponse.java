package com.pasanyasara.samplemysqlapiapp.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociationCustomResponse {

    public AssociationCustomResponse(String cnieCollab, String emailCollab, String associationStatus) {
        this.cnieCollab = cnieCollab;
        this.emailCollab = emailCollab;
        this.associationStatus = associationStatus;
    }

    private String cnieCollab;
    private String emailCollab;
    private String associationStatus;
}
