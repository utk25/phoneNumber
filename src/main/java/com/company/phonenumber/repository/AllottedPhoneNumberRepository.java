package com.company.phonenumber.repository;


import com.company.phonenumber.databasemodel.AllottedPhoneNumberDatabaseModel;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;


public interface AllottedPhoneNumberRepository extends CrudRepository<AllottedPhoneNumberDatabaseModel, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select distinct adm " +
            "from AllottedPhoneNumberDatabaseModel adm " +
            "where adm.number = :phoneNumber")
    AllottedPhoneNumberDatabaseModel findAllottedPhoneNumberDatabaseModelByNumber(@Param("phoneNumber") long phoneNumber);
}