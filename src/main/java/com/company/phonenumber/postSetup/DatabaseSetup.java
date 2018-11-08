package com.company.phonenumber.postSetup;

import com.company.phonenumber.model.PhoneNumberDatabaseModel;
import com.company.phonenumber.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseSetup implements CommandLineRunner {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Override
    public void run(String...args) throws Exception {

        PhoneNumberDatabaseModel phoneNumberDatabaseModel = new PhoneNumberDatabaseModel();
        phoneNumberService.addPhoneNumber(phoneNumberDatabaseModel);

    }
}
