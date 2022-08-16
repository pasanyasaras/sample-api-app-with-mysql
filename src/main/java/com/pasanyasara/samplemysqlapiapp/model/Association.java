package com.pasanyasara.samplemysqlapiapp.model;

import com.pasanyasara.samplemysqlapiapp.service.AssociationService;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String CNIE_Manager;
    private String Email_Manager;
    private String Email_Collab;
    private String CNIE_Collab;
    private String FirstName_Collab;
    private String LastName_Collab;
    private String Qualification_Collab;
    private Date Association_Req_Date;
    private String Association_Status;
    private String Comp_Denomination;
    private String RC_Num;
    private String Jurisdiction_id;

    public Association() {
    }

    public Association(String CNIE_Manager) {
        //this.CNIE_Manager = CNIE_Manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCNIE_Manager() {
        return CNIE_Manager;
    }

    public void setCNIE_Manager(String CNIE_Manager) {
        this.CNIE_Manager = CNIE_Manager;
    }

    public String getEmail_Manager() {
        return Email_Manager;
    }

    public void setEmail_Manager(String email_Manager) {
        Email_Manager = email_Manager;
    }

    public String getEmail_Collab() {
        return Email_Collab;
    }

    public void setEmail_Collab(String email_Collab) {
        Email_Collab = email_Collab;
    }

    public String getCNIE_Collab() {
        return CNIE_Collab;
    }

    public void setCNIE_Collab(String CNIE_Collab) {
        this.CNIE_Collab = CNIE_Collab;
    }

    public String getFirstName_Collab() {
        return FirstName_Collab;
    }

    public void setFirstName_Collab(String firstName_Collab) {
        FirstName_Collab = firstName_Collab;
    }

    public String getLastName_Collab() {
        return LastName_Collab;
    }

    public void setLastName_Collab(String lastName_Collab) {
        LastName_Collab = lastName_Collab;
    }

    public String getQualification_Collab() {
        return Qualification_Collab;
    }

    public void setQualification_Collab(String qualification_Collab) {
        Qualification_Collab = qualification_Collab;
    }

    public Date getAssociation_Req_Date() {
        return Association_Req_Date;
    }

    public void setAssociation_Req_Date(Date association_Req_Date) {
        Association_Req_Date = association_Req_Date;
    }

    public String getAssociation_Status() {
        return Association_Status;
    }

    public void setAssociation_Status(String association_Status) {
        Association_Status = association_Status;
    }

    public String getComp_Denomination() {
        return Comp_Denomination;
    }

    public void setComp_Denomination(String comp_Denomination) {
        Comp_Denomination = comp_Denomination;
    }

    public String getRC_Num() {
        return RC_Num;
    }

    public void setRC_Num(String RC_Num) {
        this.RC_Num = RC_Num;
    }

    public String getJurisdiction_id() {
        return Jurisdiction_id;
    }

    public void setJurisdiction_id(String jurisdiction_id) {
        Jurisdiction_id = jurisdiction_id;
    }


}
