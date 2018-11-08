package com.company.phonenumber.controller;

import com.company.phonenumber.adapter.PhoneNumberAdapter;
import com.company.phonenumber.model.*;
import com.company.phonenumber.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Autowired
    private PhoneNumberAdapter phoneNumberAdapter;

    @RequestMapping(method = RequestMethod.POST, value = "/phoneNumber")
    public AllottedPhoneNumberDatabaseModel newPhoneNumber(@RequestBody NewPhoneNumberRequestModel newPhoneNumberRequestModel) {

        return phoneNumberService.getNewPhoneNumber(newPhoneNumberRequestModel);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/specialPhoneNumber")
    public AllottedPhoneNumberDatabaseModel newSpecialPhoneNumber(@RequestBody SpecialPhoneNumberRequestModel specialPhoneNumberRequestModel) {

        return phoneNumberService.getSpecialPhoneNumber(specialPhoneNumberRequestModel);
    }

}