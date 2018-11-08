package com.company.phonenumber.servicemodel;


import lombok.Data;

@Data
public class SpecialPhoneNumberRequestModel {

    private Integer clientId;

    private Long specialNumber;
}
