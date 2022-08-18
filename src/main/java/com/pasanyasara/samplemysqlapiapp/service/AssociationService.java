package com.pasanyasara.samplemysqlapiapp.service;


import com.pasanyasara.samplemysqlapiapp.model.Association;

import java.util.List;

public interface AssociationService {
    Iterable getAllAssociations();

    String addAssociation(String CNIEManager, String emailManager, String emailCollab,
                             String qualificationColab, String compDenomination, String rcNum, String jurisdictionId);

    List<Association> getAllAssociationsByCnieManager(String CnieManager);

    String getCnieManagerByCnieCollab(String CnieCollab);

    boolean isAssociationAvailableForCnieCollab(String cnieCollab);

    String getAssociationStatusByCnieCollab(String cnieCollab);

    String expireAssociationsByEmailCollabAndEmailManager(String emailCollab, String emailManager);





    Integer disableAssociationsByCnieManager(String cnieManager);

    Integer disableAssociationsByCnieCollab(String cnieManager);

    Integer disableAssociationsByCnieManagerAndCnieCollab(String cnieManager, String cnieCollab);

//    Association getAssociationsByCnieManager(String cnieManager);

}
