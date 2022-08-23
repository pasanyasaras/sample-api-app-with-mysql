package com.pasanyasara.samplemysqlapiapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociationDTO {

    private Boolean isVerified;
    private String  emailManager;
    private String  emailCollaborator;
    private String  firstNameCollaborator;
    private String  lastNameCollaborator;
    private String  cnieCollaborator;


}
