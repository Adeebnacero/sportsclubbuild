package com.example.demo.Factory;

import com.example.demo.Domain.Coach;

/**
 * Created by Adeebo on 2017/08/21.
 */
public class CoachFactory {

    public static Coach buildCoach(String firstName, String lastName, String DOB,String status){

        Coach coach = new Coach.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDOB(DOB)
                .setStatus(status)
                .build();
        return coach;
    }
}