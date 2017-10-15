package com.example.demo.Factory;

import com.example.demo.Domain.Administrator;

/**
 * Created by Adeebo on 2017/08/21.
 */
public class AdministratorFactory {

    public static Administrator buildAdministrator(String firstName, String lastName, String designation,String DOB,String status){

        Administrator admin = new Administrator.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDesignation(designation)
                .setDOB(DOB)
                .setStatus(status)
                .build();

        return admin;
    }
}
