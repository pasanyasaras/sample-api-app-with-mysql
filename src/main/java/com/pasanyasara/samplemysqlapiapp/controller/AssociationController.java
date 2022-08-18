package com.pasanyasara.samplemysqlapiapp.controller;

import com.pasanyasara.samplemysqlapiapp.enums.AssociationStatus;
import com.pasanyasara.samplemysqlapiapp.model.Association;
import com.pasanyasara.samplemysqlapiapp.repository.AssociationRepository;
import com.pasanyasara.samplemysqlapiapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/manager/v1")
public class AssociationController {

    @Autowired
    private AssociationRepository associationRepository;

    @Autowired
    private AssociationService associationService;

    @GetMapping
    public @ResponseBody Iterable<Association> getAllAssociations(){
//        Iterable<Association> iterable = associationRepository.findAll();
//        for(Association i : iterable)
//        {
//            System.out.println(i.getCNIE_Manager());
//        }
        //Association association = associationService.getAllAssociationsByCnieManager("PA173101").get(0);
        //System.out.println(associationService.getAllAssociationsByCnieManager("PA173101").size());
        System.out.println(AssociationStatus.ACTIVE.getAssociationStatus());
        return associationService.getAllAssociations();
    }

//    @PostMapping("/associations/add")
//    public @ResponseBody String addNewAssociation(){
//        Association association = new Association();
//        association.setCNIE_Manager("CNIE_Manager001");
//        association.setEmail_Manager("CNIE_Manager001@EmailManager.com");
//        association.setEmail_Collab("Cniecollab@test.com");
//        association.setQualification_Collab("Qualf");
//        Date date = new Date();
//        association.setAssociation_Req_Date(date);
//        association.setAssociation_Status("Pending");
//        association.setComp_Denomination("EXECompany");
//        association.setRC_Num("93244");
//        association.setJurisdiction_id("532");
//        associationRepository.save(association);
//
//        return "Saved";
//    }

//    @GetMapping("/associations/{cnie_Collab}")
//    public @ResponseBody List<Association> getAllAssociationByCNIE(@PathVariable String cnie_Collab){
//        //System.out.println(associationRepository.checkAssociationStatus(cnie_Collab));
//        return associationRepository.sqlAssociationByCnie(cnie_Collab);
//
//
//    }

    @GetMapping("/manager/{cnieManager}")
    public @ResponseBody ResponseEntity<ArrayList<Association>> getAssociationsByCnieManager(@PathVariable String cnieManager)
    {
        ArrayList<Association> associationsList = new ArrayList<Association>();

        for(Association association : associationService.getAllAssociationsByCnieManager(cnieManager))
        {
            associationsList.add(association);
        }

        if(associationsList.isEmpty())
        {
            return new ResponseEntity<ArrayList<Association>>(associationsList,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ArrayList<Association>>(associationsList,HttpStatus.OK);
    }

//    @GetMapping("/manager/{cnieManager}")
//    public @ResponseBody ResponseEntity<ArrayList<HashMap<String,Object>>> getAssociationsByCnieManager(@PathVariable String cnieManager)
//    {
//        Map<String, Object> associationMap ;
//        ArrayList<HashMap<String,Object>> associationsList = new ArrayList<HashMap<String,Object>>();
//
//        for(Association association : associationService.getAllAssociationsByCnieManager(cnieManager))
//        {
//            associationMap = new HashMap<String,Object>();
//            //System.out.println(association.getCNIE_Collab());
//            associationMap.put(AssociationConstant.CNIE_COLLAB,association.getCnieCollab());
//            associationMap.put(AssociationConstant.EMAIL_COLLAB,association.getEmailCollab());
//            associationMap.put(AssociationConstant.ASSOCIATION_STATUS,association.getAssociationStatus());
//            associationsList.add((HashMap<String, Object>) associationMap);
//
//        }
//        if(associationsList.isEmpty())
//        {
//            return new ResponseEntity<ArrayList<HashMap<String,Object>>>(associationsList,HttpStatus.NOT_FOUND);
//        }
//
//
//        return new ResponseEntity<ArrayList<HashMap<String,Object>>>(associationsList,HttpStatus.OK);
//    }





//    @PostMapping("/manager/{cnieManager}")
//    public ResponseEntity<String> disableAssociations(@RequestBody ArrayList<Association> associationList, @PathVariable String cnieManager){
//        int cnieCollabCount=0;
//        for(Association association : associationList)
//        {
//            cnieCollabCount = cnieCollabCount + associationService.disableAssociationsByCnieManagerAndCnieCollab(cnieManager,association.getCnieCollab());
//        }
//        return new ResponseEntity<String>(cnieCollabCount+" Associations disabled",HttpStatus.OK);
//    }

    @PostMapping("/manager/{cnieManager}")
    public ResponseEntity<String> disableAssociations(@RequestBody ArrayList<Association> associationList, @PathVariable String cnieManager){
        int cnieCollabCount=0;

        for(Association association : associationList)
        {
            cnieCollabCount += associationService.disableAssociationsByCnieManagerAndCnieCollab(cnieManager,association.getCnieCollab());
        }

        return new ResponseEntity<String>(cnieCollabCount+" Associations disabled",HttpStatus.OK);
    }

//    @PostMapping("/manager/{cnieManager}")
//    public ResponseEntity<String> disableAssociations(@RequestBody ArrayList<HashMap<String,String>> associationList, @PathVariable String cnieManager){
//        int cnieCollabCount=0;
//        for(HashMap<String,String> associationHashMap : associationList)
//        {
//            cnieCollabCount = cnieCollabCount + associationService.disableAssociationsByCnieManagerAndCnieCollab(cnieManager,associationHashMap.get(AssociationConstant.CNIE_COLLAB));
//        }
//        return new ResponseEntity<String>(cnieCollabCount+" Associations disabled",HttpStatus.OK);
//    }


    @GetMapping("/associations/{CnieCollab}")
    public ResponseEntity<String> configureAssociationsByCnieCollab(@PathVariable String cnieCollab)
    {
        if(!associationService.isAssociationAvailableForCnieCollab(cnieCollab))
        {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        if(associationService.getAssociationStatusByCnieCollab(cnieCollab).equals(AssociationStatus.ACTIVE.getAssociationStatus()))
        {
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        else{

            return new ResponseEntity<String>(associationService.disableAssociationsByCnieManager(associationService.getCnieManagerByCnieCollab(cnieCollab))
                    +" associations are Disabled",HttpStatus.UNAUTHORIZED);
        }


    }

    @GetMapping("/associations/managerall/{cnieManager}")
    public @ResponseBody List<Association> getAllAssociationByCNIEManager(@PathVariable String cnieManager){

        //return associationRepository.sqlFetchAssociationsByCNIEManager(cnieManager);
        return associationService.getAllAssociationsByCnieManager(cnieManager);
    }

    @PutMapping ("/associations/manager/disable/{cnieManager}")
    public ResponseEntity<String> disableAssociationsByCnieManager(@PathVariable String cnieManager){
        return new ResponseEntity<String>(associationService.disableAssociationsByCnieManager(cnieManager)+" associations disabled.", HttpStatus.UNAUTHORIZED);
    }

//    @PutMapping ("/associations/manager/activate/{cnieManager}")
//    public ResponseEntity<String> activateAssociationsByCnieManager(@PathVariable String cnieManager){
//        return new ResponseEntity<String>(associationRepository.activateAssociationsByCNIEManager(cnieManager)+" associations activated.", HttpStatus.OK);
//    }

    @PutMapping("/associations/cniecollab/disable/{cnieCollab}")
    public ResponseEntity<String> disableAssociationsByCnieCollab(@PathVariable String cnieCollab){
        return new ResponseEntity<String>(associationService.disableAssociationsByCnieCollab(cnieCollab)+" associations disabled.", HttpStatus.UNAUTHORIZED);
    }
}
