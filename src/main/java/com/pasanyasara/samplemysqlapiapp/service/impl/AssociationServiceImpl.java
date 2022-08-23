package com.pasanyasara.samplemysqlapiapp.service.impl;

import com.pasanyasara.samplemysqlapiapp.enums.AssociationStatus;
import com.pasanyasara.samplemysqlapiapp.model.Association;
import com.pasanyasara.samplemysqlapiapp.repository.AssociationRepository;
import com.pasanyasara.samplemysqlapiapp.service.AssociationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssociationServiceImpl implements AssociationService {

    private static final Logger LOG = LoggerFactory.getLogger(AssociationServiceImpl.class);
    @Autowired
    private AssociationRepository associationRepository;

    @Value("${associations.base.url}")
    private String associationsBaseUrl;


    @Override
    public Iterable getAllAssociations() {
        return associationRepository.findAll();
    }

    @Override
    public String addAssociation(String cnieManager, String emailManager, String emailCollab,
                                    String qualificationColab, String compDenomination, String rcNum, String jurisdictionId){
        Association association = new Association();
        association.setCnieManager(cnieManager);
        association.setEmailManager(emailManager);
        association.setEmailCollab(emailCollab);
        association.setQualificationCollab(qualificationColab);
        Date date = new Date();
        association.setAssociationReqDate(date);
        association.setAssociationStatus(AssociationStatus.PENDING.getAssociationStatus());
        association.setCompDenomination(compDenomination);
        association.setRcNum(rcNum);
        association.setJurisdictionId(jurisdictionId);
        association.setCnieCollab("");
        association.setFirstNameCollab("");
        association.setLastNameCollab("");
        associationRepository.save(association);

        return "Saved";
    }

    public List<Association> getAllAssociationsByCnieManager(String cnieManager){
        return associationRepository.findByCnieManager(cnieManager);
    }



    public String getCnieManagerByCnieCollab(String cnieCollab){
        Optional<Association> optionalAssociation = associationRepository.findByCnieCollab(cnieCollab);
        Association association = optionalAssociation.get();

        return association.getCnieManager();
    }

    public String getAssociationStatusByCnieCollab(String cnieCollab){
        Optional<Association> optionalAssociation = associationRepository.findByCnieCollab(cnieCollab);
        Association association = optionalAssociation.get();
        return association.getAssociationStatus();
    }

    @Override
    public String expireAssociationsByEmailCollabAndEmailManager(String emailCollab, String emailManager) {
        Optional<Association> optionalAssociation = associationRepository.findByEmailCollabAndEmailManager(emailCollab,emailManager);
        if(optionalAssociation.isPresent())
        {
            Association association = optionalAssociation.get();
            association.setAssociationStatus(AssociationStatus.EXPIRED.getAssociationStatus());
            associationRepository.save(association);
            return "Association is disabled";
        }
        else
        {
            return "No association found to expire";
        }

    }


    public boolean isAssociationAvailableForCnieCollab(String cnieCollab)
    {
        Optional<Association> optionalAssociation = associationRepository.findByCnieCollab(cnieCollab);
        if(optionalAssociation.isPresent())
        {
            LOG.info("Association is available for {}",cnieCollab);
            return true;
        }
        else{
            LOG.info("No association is available for {}",cnieCollab);
            return false;
        }


    }



    public Integer disableAssociationsByCnieManager(String cnieManager){
        int associationsCount=0;
        List<Association> associationList = associationRepository.findByCnieManager(cnieManager);
        for(Association association : associationList)
        {
            association.setAssociationStatus(AssociationStatus.DISABLED.getAssociationStatus());
            associationRepository.save(association);
            associationsCount++;
        }
        return associationsCount;
    }

    public Integer disableAssociationsByCnieCollab(String cnieCollab){
        int associationsCount=0;
        Optional<Association> optionalAssociation = associationRepository.findByCnieCollab(cnieCollab);
        if(optionalAssociation.isPresent())
        {
            Association association = optionalAssociation.get();
            association.setAssociationStatus(AssociationStatus.DISABLED.getAssociationStatus());
            associationRepository.save(association);
            associationsCount++;
            LOG.info("Association is disabled: {}",cnieCollab);
        }
        else
        {
            LOG.info("No association found for {}",cnieCollab);
        }
        return associationsCount;
    }

    @Override
    public Integer disableAssociationsByCnieManagerAndCnieCollab(String cnieManager, String cnieCollab) {
        int associationsCount=0;

        Optional<Association> optionalAssociation = associationRepository.findByCnieManagerAndCnieCollab(cnieManager,cnieCollab);
        if(optionalAssociation.isPresent())
        {
            Association association = optionalAssociation.get();
            association.setAssociationStatus(AssociationStatus.DISABLED.getAssociationStatus());
            associationRepository.save(association);
            associationsCount++;
            LOG.info("Association is disabled: cnieManager: {} || cnieCollab: {}",cnieManager,cnieCollab);

        }
        else
        {
            LOG.info("No association found: cnieManager: {} || cnieCollab: {}",cnieManager,cnieCollab);
        }
        return associationsCount;
    }

    @Override
    public void updateAssociation(String emailManager, String emailCollab, String cnieCollab, String firstNameCollab, String lastNameCollab) {
        Optional<Association> optionalAssociation = associationRepository.findByEmailCollabAndEmailManager(emailManager, emailCollab);
        if(optionalAssociation.isPresent())
        {
            Association association = optionalAssociation.get();
            association.setCnieCollab(cnieCollab);
            association.setFirstNameCollab(firstNameCollab);
            association.setLastNameCollab(lastNameCollab);
            associationRepository.save(association);
            LOG.info("Association is updated: emailManager: {} || emailCollab: {}",emailManager,emailCollab);
        }
        else{
            LOG.info("No association updated: emailManager: {} || emailCollab: {}",emailManager,emailCollab);
        }

    }

    @Override
    public boolean isAssociationAvailableByEmailManagerAndEmailCollab(String emailManager, String emailCollab) {
        Optional<Association>  optionalAssociation= associationRepository.findByEmailManagerAndEmailCollab(emailManager,emailCollab);
        if(optionalAssociation.isPresent())
        {
            return true;
        }
        else{
            return false;
        }
    }

//    @Override
//    public Association getAssociationsByCnieManager(String cnieManager) {
//        return associationRepository.getAssociationsByCnieManager(cnieManager);
//    }
}
