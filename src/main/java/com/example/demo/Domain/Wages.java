package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Adeebo on 2017/09/09.
 */
@Entity
public class Wages implements Serializable {

    @Id
    @GeneratedValue
    private Integer wageID;
    private Integer clubID;
    private Integer level;
    private String firstName;
    private String lastName;
    private float amount;

    public Wages() {
    }

    public Wages (Builder builder){

        this.wageID = builder.wageID;
        this.clubID = builder.clubID;
        this.level = builder.level;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.amount = builder.amount;
    }

    public static class Builder{

        private Integer wageID;
        private Integer clubID;
        private Integer level;
        private String firstName;
        private String lastName;
        private float amount;

        public Builder setWageID(Integer wageID) {
            this.wageID = wageID;
            return this;
        }

        public Builder setClubID(Integer clubID) {
            this.clubID = clubID;
            return this;
        }

        public Builder setLevel(Integer level) {
            this.level = level;
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

        public Builder setAmount(float amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(Wages value){

            this.wageID = value.wageID;
            this.clubID = value.clubID;
            this.level = value.level;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.amount = value.amount;

            return this;
        }

        public Wages build(){

            return new Wages(this);
        }
    }

    public Integer getWageID() {
        return wageID;
    }

    public Integer getClubID() {
        return clubID;
    }

    public Integer getLevel() {

        return level;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getAmount() {

        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wages)) return false;

        Wages wages = (Wages) o;

        return wageID.equals(wages.wageID);

    }

    @Override
    public int hashCode() {
        return wageID.hashCode();
    }

    @Override
    public String toString() {
        return "Wages" + '\n' +
                "WageID: " + wageID + '\n' +
                "ClubID: " + clubID + '\n' +
                "Level: " + level + '\n' +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Amount: R" + amount;
    }
}
