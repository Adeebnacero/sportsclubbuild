package com.example.demo.Factory;

import com.example.demo.Domain.UserRoles;

/**
 * Created by Adeebo on 2017/09/06.
 */
public class UserRolesFactory {

    public static UserRoles buildUserRoles(String designation,Integer clubID, String lastName, String status) {

        UserRoles user = new UserRoles.Builder()
                .setRole(designation)
                .setClubID(clubID)
                .setPassword(lastName)
                .setStatus(status)
                .build();

        return user;
    }
}
