package com.company.phonenumber.adapter;

import com.company.phonenumber.databasemodel.*;
import com.company.phonenumber.service.PhoneNumberService;
import com.company.phonenumber.servicemodel.PhoneNumberRequestModel;
import com.company.phonenumber.servicemodel.SpecialPhoneNumberRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberAdapter {

    @Autowired
    private PhoneNumberService phoneNumberService;

    public AllottedPhoneNumberDatabaseModel convertToDatabaseModel(PhoneNumberRequestModel phoneNumberRequestModel, Long phoneNumber) {
        //Performs ORM
        AllottedPhoneNumberDatabaseModel allottedPhoneNumberDatabaseModel = new AllottedPhoneNumberDatabaseModel();
        allottedPhoneNumberDatabaseModel.setClientId(phoneNumberRequestModel.getClientId());
        allottedPhoneNumberDatabaseModel.setNumber(phoneNumber);
        return allottedPhoneNumberDatabaseModel;
    }

    public AllottedPhoneNumberDatabaseModel convertToDatabaseModel(SpecialPhoneNumberRequestModel specialPhoneNumberRequestModel) {
        //Performs ORM
        AllottedPhoneNumberDatabaseModel allottedPhoneNumberDatabaseModel = new AllottedPhoneNumberDatabaseModel();
        allottedPhoneNumberDatabaseModel.setClientId(specialPhoneNumberRequestModel.getClientId());
        allottedPhoneNumberDatabaseModel.setNumber(specialPhoneNumberRequestModel.getSpecialNumber());
        return allottedPhoneNumberDatabaseModel;
    }
}
