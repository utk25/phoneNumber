package com.company.phonenumber.repository;


import com.company.phonenumber.databasemodel.PhoneNumberDatabaseModel;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumberDatabaseModel, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select pdm from PhoneNumberDatabaseModel pdm " +
            "where pdm.id = :id")
    PhoneNumberDatabaseModel findPhoneNumberDatabaseModelByIndex(@Param("id") int index);

}
