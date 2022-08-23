package com.pasanyasara.samplemysqlapiapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDTO {
    @JsonProperty("NumeroPiece")
    private String NumeroPiece;
    @JsonProperty("Nom")
    private String Nom;
    @JsonProperty("CodeTypePiece")
    private String CodeTypePiece;

}
