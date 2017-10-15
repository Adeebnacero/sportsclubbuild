package com.example.demo.Factory;

import com.example.demo.Domain.Player;

/**
 * Created by Adeebo on 2017/08/21.
 */
public class PlayerFactory {

    public static Player buildPlayer(String firstName, String lastName, String DOB,String ID, String position,String strongFoot,String status){

        Player player = new Player.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDOB(DOB)
                .setID(ID)
                .setPosition(position)
                .setStrongFoot(strongFoot)
                .setStatus(status)
                .build();
        return player;
    }
}
