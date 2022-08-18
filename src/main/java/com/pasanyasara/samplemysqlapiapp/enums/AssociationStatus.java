package com.pasanyasara.samplemysqlapiapp.enums;

public enum AssociationStatus {
    ACTIVE("Active"),
    DISABLED("Disabled"),
    EXPIRED("Expired"),
    PENDING("Pending");

    private final String associationStatus;

    AssociationStatus(String status) {
        this.associationStatus=status;
    }

    public String getAssociationStatus() {
        return this.associationStatus;
    }
}
