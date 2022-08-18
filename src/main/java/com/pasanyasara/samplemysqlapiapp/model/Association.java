package com.pasanyasara.samplemysqlapiapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="cnie_manager")
    private String cnieManager;

    @Column(name="email_manager")
    private String emailManager;

    @Column(name="email_collab")
    private String emailCollab;

    @Column(name="cnie_collab")
    private String cnieCollab;

    @Column(name="firstName_collab")
    private String firstNameCollab;

    @Column(name="lastName_collab")
    private String lastNameCollab;

    @Column(name="qualification_collab")
    private String qualificationCollab;

    @Column(name="association_req_date")
    private Date associationReqDate;

    @Column(name="association_status")
    private String associationStatus;

    @Column(name="comp_denomination")
    private String compDenomination;

    @Column(name="rc_num")
    private String rcNum;

    @Column(name="jurisdiction_id")
    private String jurisdictionId;


}
