package com.pasanyasara.samplemysqlapiapp.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDetailsDTO {
    @JsonProperty("Success")
    private boolean Success;
    @JsonProperty("Message")
    private String  Message;
    @JsonProperty("PersonneRc")
    private PersonneRcDTO PersonneRc;

}
