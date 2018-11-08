package com.company.phonenumber.service;


import com.company.phonenumber.adapter.PhoneNumberAdapter;
import com.company.phonenumber.constants.PhoneNumberConstants;
import com.company.phonenumber.exception.PhoneNumberExhaustedException;
import com.company.phonenumber.exception.PhoneNumberOutOfRangeException;
import com.company.phonenumber.databasemodel.AllottedPhoneNumberDatabaseModel;
import com.company.phonenumber.servicemodel.PhoneNumberRequestModel;
import com.company.phonenumber.databasemodel.PhoneNumberDatabaseModel;
import com.company.phonenumber.servicemodel.SpecialPhoneNumberRequestModel;
import com.company.phonenumber.repository.AllottedPhoneNumberRepository;
import com.company.phonenumber.repository.PhoneNumberRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private AllottedPhoneNumberRepository allottedPhoneNumberRepository;

    @Autowired
    private PhoneNumberAdapter phoneNumberAdapter;

    @NonNull
    public AllottedPhoneNumberDatabaseModel getNewPhoneNumber(PhoneNumberRequestModel phoneNumberRequestModel) {

        long phoneNumber = getCurrentPhoneNumber();

        if (phoneNumber == PhoneNumberConstants.LAST_NUMBER + 1) {
            throw new PhoneNumberExhaustedException("All Phone Number are allotted");
        }

        while (!isPhoneNumberAvailable(phoneNumber)) {
            phoneNumber += 1;
        }

        AllottedPhoneNumberDatabaseModel allottedPhoneNumberDatabaseModel = phoneNumberAdapter.convertToDatabaseModel(phoneNumberRequestModel, phoneNumber);
        allottedPhoneNumberRepository.save(allottedPhoneNumberDatabaseModel);

        updatePhoneNumberDatabaseModel(phoneNumber);

        return allottedPhoneNumberDatabaseModel;
    }

    @NonNull
    public AllottedPhoneNumberDatabaseModel getSpecialPhoneNumber(SpecialPhoneNumberRequestModel specialPhoneNumberRequestModel) {

        long phoneNumber = getCurrentPhoneNumber();

        if (phoneNumber == PhoneNumberConstants.LAST_NUMBER + 1) {
            throw new PhoneNumberExhaustedException("All Phone numbers are allotted");
        }

        if (specialPhoneNumberRequestModel.getSpecialNumber() < PhoneNumberConstants.STARTING_NUMBER ||
                specialPhoneNumberRequestModel.getSpecialNumber() > PhoneNumberConstants.LAST_NUMBER) {
            throw new PhoneNumberOutOfRangeException("Phone number requested is out of range");
        }

        if (!isPhoneNumberAvailable(specialPhoneNumberRequestModel.getSpecialNumber()) || specialPhoneNumberRequestModel.getSpecialNumber() <= phoneNumber) {
            specialPhoneNumberRequestModel.setSpecialNumber(phoneNumber);
            updatePhoneNumberDatabaseModel(phoneNumber);
        }

        AllottedPhoneNumberDatabaseModel allottedPhoneNumberDatabaseModel = phoneNumberAdapter.convertToDatabaseModel(specialPhoneNumberRequestModel);
        allottedPhoneNumberRepository.save(allottedPhoneNumberDatabaseModel);

        return allottedPhoneNumberDatabaseModel;
    }

    private boolean isPhoneNumberAvailable(Long phoneNumber) {

        AllottedPhoneNumberDatabaseModel allottedPhoneNumberDatabaseModel = allottedPhoneNumberRepository.findAllottedPhoneNumberDatabaseModelByNumber(phoneNumber);
        return allottedPhoneNumberDatabaseModel == null;
    }

    private PhoneNumberDatabaseModel getCurrentPhoneNumberDatabaseModel() {

        return phoneNumberRepository.findPhoneNumberDatabaseModelByIndex(PhoneNumberConstants.TABLE_ROW);
    }

    private Long getCurrentPhoneNumber() {

        return getCurrentPhoneNumberDatabaseModel().getNumber();
    }

    private void updatePhoneNumberDatabaseModel(Long phoneNumber) {

        PhoneNumberDatabaseModel phoneNumberDatabaseModel = getCurrentPhoneNumberDatabaseModel();
        phoneNumberDatabaseModel.setNumber(phoneNumber + 1);
        addPhoneNumber(phoneNumberDatabaseModel);
    }

    @NonNull
    public void addPhoneNumber(PhoneNumberDatabaseModel phoneNumberDatabaseModel) {

        phoneNumberRepository.save(phoneNumberDatabaseModel);
    }
}
