package com.pasanyasara.samplemysqlapiapp.constant;

public class ScimConstant {
    private ScimConstant() {}

    public static final String SCIM_PATCH_OPERATION =
            "urn:ietf:params:scim:api:messages:2.0:PatchOp";
    public static final String SCIM_USER_EXTENSION_SCHEMA =
            "urn:ietf:params:scim:schemas:extension:enterprise:2.0:User";
    public static final String SCIM_SCHEMA_FIELD = "schemas";
    public static final String SCIM_OPERATIONS_FIELD = "Operations";
    public static final String SCIM_PATCH_USER_OPERATION = "replace";
    public static final String SCIM_PATCH_USER_OPERATION_KEY = "op";
    public static final String VALUE = "value";
    public static final String DGSN_VERIFICATION_STATUS = "dgsnVerificationStatus";
    public static final String UNIDENTIFIER = "unIdentifier";


    /***********************************/
    public static final String ID = "id";
    public static final String RC_NUM = "rc_Num";
    public static final String CNIE_MANAGER = "cnie_Manager";
    public static final String EMAIL_MANAGER = "email_Manager";
    public static final String EMAIL_COLLAB = "email_Collab";
    public static final String CNIE_COLLAB = "cnie_Collab";
    public static final String FIRST_NAME_COLLAB = "firstName_Collab";
    public static final String LAST_NAME_COLLAB = "lastName_Collab";
    public static final String QUALIFICATION_COLLAB = "qualification_Collab";
    public static final String ASSOCIATION_REQ_DATE = "association_Req_Date";
    public static final String ASSOCIATION_STATUS = "association_Status";
    public static final String COMP_DENOMINATION = "comp_Denomination";
    public static final String JURISDICTION_ID = "jurisdiction_id";
}
