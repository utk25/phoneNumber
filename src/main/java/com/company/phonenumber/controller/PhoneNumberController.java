package com.company.phonenumber.controller;

import com.company.phonenumber.adapter.PhoneNumberAdapter;
import com.company.phonenumber.databasemodel.*;
import com.company.phonenumber.service.PhoneNumberService;
import com.company.phonenumber.servicemodel.PhoneNumberRequestModel;
import com.company.phonenumber.servicemodel.SpecialPhoneNumberRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Autowired
    private PhoneNumberAdapter phoneNumberAdapter;

    @RequestMapping(method = RequestMethod.POST, value = "/phoneNumber")
    public AllottedPhoneNumberDatabaseModel getPhoneNumber(@RequestBody PhoneNumberRequestModel phoneNumberRequestModel) {

        return phoneNumberService.getNewPhoneNumber(phoneNumberRequestModel);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/specialPhoneNumber")
    public AllottedPhoneNumberDatabaseModel getSpecialPhoneNumber(@RequestBody SpecialPhoneNumberRequestModel specialPhoneNumberRequestModel) {

        return phoneNumberService.getSpecialPhoneNumber(specialPhoneNumberRequestModel);
    }

}