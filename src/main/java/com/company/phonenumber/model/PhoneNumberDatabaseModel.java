package com.company.phonenumber.model;

import com.company.phonenumber.constants.PhoneNumber;
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
    private Long number = PhoneNumber.STARTING_NUMBER;
}


