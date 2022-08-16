package com.pasanyasara.samplemysqlapiapp.service;


import com.pasanyasara.samplemysqlapiapp.model.Association;

import java.util.List;

public interface AssociationService {

    String addNewAssociation(String CNIEManager, String emailManager, String emailCollab,
                             String qualificationColab, String compDenomination, String rcNum, String jurisdictionId);

    List<Association> getAllAssociationsByCnieManager(String CnieManager);

    String getAssociationStatusByCnieCollab(String CnieCollab);

    Integer getAssociationAvailabilityCountByCnieCollab(String CnieCollab);

    String getCnieManagerByCnieCollab(String CnieCollab);

    Integer disableAssociationsByCNIEManager(String cnieManager);

    Integer disableAssociationsByCNIECollab(String cnieManager);

//    Association getAssociationsByCnieManager(String cnieManager);

}
