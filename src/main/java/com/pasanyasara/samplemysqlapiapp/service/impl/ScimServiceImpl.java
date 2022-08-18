package com.pasanyasara.samplemysqlapiapp.service.impl;


import com.pasanyasara.samplemysqlapiapp.repository.AssociationRepository;
import com.pasanyasara.samplemysqlapiapp.service.ScimService;
import com.pasanyasara.samplemysqlapiapp.utill.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


public class ScimServiceImpl implements ScimService {

    private static final Logger LOG = LoggerFactory.getLogger(ScimServiceImpl.class);

    HttpClient httpClient;

    @Autowired
    private AssociationRepository associationRepository;

    @Value("${associations.base.url}")
    private String associationsBaseUrl;

//    private Association setAssociationValues(JsonObject jsonObject) throws ParseException {
//        Association association = new Association();
//
//        Integer id = Integer.parseInt(jsonObject.get(ScimConstant.ID).getAsString());
//        String rc_num = jsonObject.get(ScimConstant.RC_NUM).getAsString();
//        String cnie_manager = jsonObject.get(ScimConstant.CNIE_MANAGER).getAsString();
//        String email_manager = jsonObject.get(ScimConstant.EMAIL_MANAGER).getAsString();
//        String email_collab = jsonObject.get(ScimConstant.EMAIL_COLLAB).getAsString();
//        String cnie_collab = jsonObject.get(ScimConstant.CNIE_COLLAB).getAsString();
//        String firstNameCollab = jsonObject.get(ScimConstant.FIRST_NAME_COLLAB).getAsString();
//        String lastNameCollab = jsonObject.get(ScimConstant.LAST_NAME_COLLAB).getAsString();
//        String qualificationCollab = jsonObject.get(ScimConstant.QUALIFICATION_COLLAB).getAsString();
//        String associationReqDate = jsonObject.get(ScimConstant.ASSOCIATION_REQ_DATE).getAsString();
//        String associationStatus = jsonObject.get(ScimConstant.ASSOCIATION_STATUS).getAsString();
//        String compDenomination = jsonObject.get(ScimConstant.COMP_DENOMINATION).getAsString();
//        String jurisdiction_id = jsonObject.get(ScimConstant.JURISDICTION_ID).getAsString();
//
//        association.setId(id);
//        association.setRC_Num(rc_num);
//        association.setCNIE_Manager(cnie_manager);
//        association.setEmail_Manager(email_manager);
//        association.setEmail_Collab(email_collab);
//        association.setCNIE_Collab(cnie_collab);
//        association.setFirstName_Collab(firstNameCollab);
//        association.setLastName_Collab(lastNameCollab);
//        association.setQualification_Collab(qualificationCollab);
//        Date associationDate = new SimpleDateFormat("yyyy-MM-dd").parse(associationReqDate.substring(0,10));
//        association.setAssociation_Req_Date(associationDate);
//        association.setAssociation_Status(associationStatus);
//        association.setComp_Denomination(compDenomination);
//        association.setJurisdiction_id(jurisdiction_id);
//
//
//        return association;
//    }



}
