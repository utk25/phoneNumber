package com.company.phonenumber.model;


import lombok.Data;

@Data
public class SpecialPhoneNumberRequestModel {

    private Integer clientId;

    private Long specialNumber;
}
