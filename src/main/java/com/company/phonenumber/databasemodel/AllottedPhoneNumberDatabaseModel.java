package com.company.phonenumber.databasemodel;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "allotted_phone_number_table")
public class AllottedPhoneNumberDatabaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "phone_number_id")
    private Integer id;

    @Column(name = "number")
    private Long number;

    @Column(name = "client_id")
    private Integer clientId;
}


