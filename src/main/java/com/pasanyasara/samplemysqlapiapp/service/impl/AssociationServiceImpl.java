package com.pasanyasara.samplemysqlapiapp.service.impl;

import com.google.gson.JsonObject;
import com.pasanyasara.samplemysqlapiapp.constant.ScimConstant;
import com.pasanyasara.samplemysqlapiapp.model.Association;
import com.pasanyasara.samplemysqlapiapp.repository.AssociationRepository;
import com.pasanyasara.samplemysqlapiapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AssociationServiceImpl implements AssociationService {
    @Autowired
    private AssociationRepository associationRepository;

    @Value("${associations.base.url}")
    private String associationsBaseUrl;

    private Association setAssociationValues(JsonObject jsonObject) throws ParseException {
        Association association = new Association();

        Integer id = Integer.parseInt(jsonObject.get(ScimConstant.ID).getAsString());
        String rc_num = jsonObject.get(ScimConstant.RC_NUM).getAsString();
        String cnie_manager = jsonObject.get(ScimConstant.CNIE_MANAGER).getAsString();
        String email_manager = jsonObject.get(ScimConstant.EMAIL_MANAGER).getAsString();
        String email_collab = jsonObject.get(ScimConstant.EMAIL_COLLAB).getAsString();
        String cnie_collab = jsonObject.get(ScimConstant.CNIE_COLLAB).getAsString();
        String firstNameCollab = jsonObject.get(ScimConstant.FIRST_NAME_COLLAB).getAsString();
        String lastNameCollab = jsonObject.get(ScimConstant.LAST_NAME_COLLAB).getAsString();
        String qualificationCollab = jsonObject.get(ScimConstant.QUALIFICATION_COLLAB).getAsString();
        String associationReqDate = jsonObject.get(ScimConstant.ASSOCIATION_REQ_DATE).getAsString();
        String associationStatus = jsonObject.get(ScimConstant.ASSOCIATION_STATUS).getAsString();
        String compDenomination = jsonObject.get(ScimConstant.COMP_DENOMINATION).getAsString();
        String jurisdiction_id = jsonObject.get(ScimConstant.JURISDICTION_ID).getAsString();

        association.setId(id);
        association.setRC_Num(rc_num);
        association.setCNIE_Manager(cnie_manager);
        association.setEmail_Manager(email_manager);
        association.setEmail_Collab(email_collab);
        association.setCNIE_Collab(cnie_collab);
        association.setFirstName_Collab(firstNameCollab);
        association.setLastName_Collab(lastNameCollab);
        association.setQualification_Collab(qualificationCollab);
        Date associationDate = new SimpleDateFormat("yyyy-MM-dd").parse(associationReqDate.substring(0,10));
        association.setAssociation_Req_Date(associationDate);
        association.setAssociation_Status(associationStatus);
        association.setComp_Denomination(compDenomination);
        association.setJurisdiction_id(jurisdiction_id);


        return association;
    }

    @Override
    public String addNewAssociation(String CNIEManager, String emailManager, String emailCollab,
                                    String qualificationColab, String compDenomination, String rcNum, String jurisdictionId){
        Association association = new Association();
        association.setCNIE_Manager(CNIEManager);
        association.setEmail_Manager(emailManager);
        association.setEmail_Collab(emailCollab);
        association.setQualification_Collab(qualificationColab);
        Date date = new Date();
        association.setAssociation_Req_Date(date);
        association.setAssociation_Status("Pending");
        association.setComp_Denomination(compDenomination);
        association.setRC_Num(rcNum);
        association.setJurisdiction_id(jurisdictionId);
        associationRepository.save(association);

        return "Saved";
    }

    public List<Association> getAllAssociationsByCnieManager(String CnieManager){
        return associationRepository.sqlFetchAssociationsByCNIEManager(CnieManager);
    }

    public String getAssociationStatusByCnieCollab(String CnieCollab){
        return associationRepository.checkAssociationStatus(CnieCollab);
    }

    public Integer getAssociationAvailabilityCountByCnieCollab(String CnieCollab){
        return associationRepository.checkAssociationAvailabilityByCnieCollab(CnieCollab);
    }

    public String getCnieManagerByCnieCollab(String CnieCollab){
        return associationRepository.getCnieManagerByCnieCollab(CnieCollab);
    }

    public Integer disableAssociationsByCNIEManager(String cnieManager){
        return associationRepository.disableAssociationsByCNIEManager(cnieManager);
    }

    public Integer disableAssociationsByCNIECollab(String cnieManager){
        return associationRepository.disableAssociationsByCNIECollab(cnieManager);
    }

//    @Override
//    public Association getAssociationsByCnieManager(String cnieManager) {
//        return associationRepository.getAssociationsByCnieManager(cnieManager);
//    }
}
