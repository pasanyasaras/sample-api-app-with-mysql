package com.pasanyasara.samplemysqlapiapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonneRcDTO {
    @JsonProperty("NumRC")
    private String NumRC;
    @JsonProperty("Adresse")
    private String Adresse;
    @JsonProperty("Denomination")
    private String Denomination;
    @JsonProperty("Etat")
    private String Etat;
    @JsonProperty("ICE")
    private String ICE;
    @JsonProperty("DirigeantPn")
    private List<ManagerDTO> DirigeantPn;

}
