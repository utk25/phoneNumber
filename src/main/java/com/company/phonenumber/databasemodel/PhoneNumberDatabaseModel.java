package com.company.phonenumber.databasemodel;

import com.company.phonenumber.constants.PhoneNumberConstants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phone_number_table")
public class PhoneNumberDatabaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "phone_number_id")
    private Integer id;

    @Column(name = "number")
    private Long number = PhoneNumberConstants.STARTING_NUMBER;
}


