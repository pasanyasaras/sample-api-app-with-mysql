package com.pasanyasara.samplemysqlapiapp.repository;

import com.pasanyasara.samplemysqlapiapp.model.Association;
import com.pasanyasara.samplemysqlapiapp.response.AssociationCustomResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association,Integer> {

    List<Association> findByCnieManager(String cnieManager);

    //List<AssociationCustomResponse> findByCnieManager(String cnieManager);

    Optional<Association> findByCnieCollab(String cnieCollab);

    Optional<Association> findByCnieManagerAndCnieCollab(String cnieManager, String cnieCollab);

    Optional<Association> findByEmailCollabAndEmailManager(String emailCollab, String emailManager);



    @Transactional
    @Modifying
    @Query("UPDATE Association a SET a.associationStatus='Active' WHERE a.cnieManager=?1")
    Integer activateAssociationsByCNIEManager(String cnieManager);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Association a SET a.associationStatus='Disabled' WHERE a.cnieCollab=?1")
//    Integer disableAssociationsByCnieCollab(String cnieCollab);
//
//    @Transactional
//    @Modifying
//    @Query("UPDATE Association a SET a.associationStatus='Disabled' WHERE a.cnieManager=?1 AND a.cnieCollab=?2")
//    Integer disableAssociationsByCnieManagerAndCnieCollab(String cnieManager, String cnieCollab);
}
