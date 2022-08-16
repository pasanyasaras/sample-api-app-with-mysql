package com.pasanyasara.samplemysqlapiapp.repository;

import com.pasanyasara.samplemysqlapiapp.model.Association;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssociationRepository extends CrudRepository<Association,Integer> {

    @Query("SELECT a FROM Association a WHERE a.CNIE_Collab=?1")
    List<Association> sqlAssociationByCnie(String cnie_Collab);

    @Query("SELECT a FROM Association a WHERE a.CNIE_Manager=?1")
    List<Association> sqlFetchAssociationsByCNIEManager(String cnieManager);

//    @Query("SELECT a FROM Association a WHERE a.CNIE_Manager=?1")
//    Association getAssociationsByCnieManager(String cnieManager);   /********/

    @Query("SELECT a.Association_Status FROM Association a WHERE a.CNIE_Collab=?1 ")
    String checkAssociationStatus(String CnieCollab);

    @Query("SELECT COUNT(a) FROM Association a WHERE a.CNIE_Collab=?1")
    Integer checkAssociationAvailabilityByCnieCollab(String CnieCollab);

    @Query("SELECT a.CNIE_Manager FROM Association a WHERE a.CNIE_Collab=?1 ")
    String getCnieManagerByCnieCollab(String CnieCollab);

    @Transactional
    @Modifying
    @Query("UPDATE Association a SET a.Association_Status='Disabled' WHERE a.CNIE_Manager=?1")
    Integer disableAssociationsByCNIEManager(String cnieManager);

    @Transactional
    @Modifying
    @Query("UPDATE Association a SET a.Association_Status='Active' WHERE a.CNIE_Manager=?1")
    Integer activateAssociationsByCNIEManager(String cnieManager);

    @Transactional
    @Modifying
    @Query("UPDATE Association a SET a.Association_Status='Disabled' WHERE a.CNIE_Collab=?1")
    Integer disableAssociationsByCNIECollab(String cnieManager);
}
