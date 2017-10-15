package com.example.demo.Factory;

import com.example.demo.Domain.Wages;

/**
 * Created by Adeebo on 2017/09/09.
 */
public class WagesFactory {

    public static Wages buildWages(Integer wageID, Integer clubID, Integer level, String firstName, String lastName, float amount){

        Wages player = new Wages.Builder()
                .setClubID(clubID)
                .setLevel(level)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAmount(amount)
                .build();

        return player;

    }
}
