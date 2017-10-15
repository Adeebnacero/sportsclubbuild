package com.example.demo.Domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adeebo on 2017/08/21.
 */
@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clubID;
    private String firstName;
    private String lastName;
    private String DOB;
    private String ID;
    private String position;
    private String strongFoot;
    private String status;

    public Player() {
    }

    public Player(Builder builder){

        this.clubID = builder.clubID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.DOB = builder.DOB;
        this.ID = builder.ID;
        this.position = builder.position;
        this.strongFoot = builder.strongFoot;
        this.status = builder.status;
    }

    public static class Builder {

        private Integer clubID;
        private String firstName;
        private String lastName;
        private String DOB;
        private String ID;
        private String position;
        private String strongFoot;
        private String status;

        public Builder setClubID(Integer clubID) {
            this.clubID = clubID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setDOB(String DOB) {
            this.DOB = DOB;
            return this;
        }

        public Builder setID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setStrongFoot(String strongFoot) {
            this.strongFoot = strongFoot;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Player value){

            this.clubID = value.clubID;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.DOB = value.DOB;
            this.ID = value.ID;
            this.position = value.position;
            this.strongFoot = value.strongFoot;
            this.status = value.status;

            return this;
        }

        public Player build(){

            return new Player(this);
        }
    }

    public Integer getClubID() {
        return clubID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getID() {
        return ID;
    }

    public String getPosition() {
        return position;
    }

    public String getStrongFoot() {
        return strongFoot;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        return clubID.equals(player.clubID);
    }

    @Override
    public int hashCode() {
        return clubID.hashCode();
    }

    @Override
    public String toString() {
        return "***Player***" +'\n' +
                "ClubID: " + clubID + '\n' +
                "FirstName: " + firstName + '\n' +
                "LastName: " + lastName + '\n' +
                "DOB: " + DOB + '\n' +
                "ID: " + ID + '\n' +
                "Position: " + position + '\n' +
                "StrongFoot: " + strongFoot + '\n' +
                "Status: " + status + '\n'
                +"******************" + '\n';
    }
}
