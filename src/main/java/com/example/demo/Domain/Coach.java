package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Adeebo on 2017/08/21.
 */
@Entity
public class Coach implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clubID;
    private String firstName;
    private String lastName;
    private String DOB;
    private String status;

    public Coach() {
    }

    public Coach (Builder builder){

        this.clubID = builder.clubID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.DOB = builder.DOB;
        this.status = builder.status;
    }

    public static class Builder{

        private Integer clubID;
        private String firstName;
        private String lastName;
        private String DOB;
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

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Coach value){

            this.clubID = value.clubID;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.DOB = value.DOB;
            this.status = value.status;

            return this;
        }

        public Coach build(){
            return new Coach(this);
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

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;

        Coach coach = (Coach) o;

        return clubID.equals(coach.clubID);

    }

    @Override
    public int hashCode() {
        return clubID.hashCode();
    }

    @Override
    public String toString() {
        return "Coach " + '\n' +
                "ClubID: " + clubID + '\n' +
                "FirstName: " + firstName + '\n' +
                "LastName: " + lastName + '\n' +
                "DOB: " + DOB + '\n' +
                "Status: " + status + '\n';
    }
}
