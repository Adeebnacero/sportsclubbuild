package com.example.demo.Domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adeebo on 2017/08/05.
 */
@Entity
public class Administrator implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clubID;
    private String firstName;
    private String lastName;
    private String designation;
    private String DOB;
    private String status;

    protected Administrator() {
    }

    public Administrator(Builder builder){

        this.clubID = builder.clubID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.designation = builder.designation;
        this.DOB = builder.DOB;
        this.status = builder.status;
    }

    public static class Builder{

        private Integer clubID;
        private String firstName;
        private String lastName;
        private String designation;
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

        public Builder setDesignation(String designation) {
            this.designation = designation;
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

        public Builder copy(Administrator value){

            this.clubID = value.clubID;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.designation = value.designation;
            this.DOB = value.DOB;
            this.status = value.status;
            return  this;
        }

        public Administrator build(){

            return new Administrator(this);
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

    public String getDesignation() {
        return designation;
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
        if (!(o instanceof Administrator)) return false;

        Administrator that = (Administrator) o;

        return clubID.equals(that.clubID);

    }

    @Override
    public int hashCode() {
        return clubID.hashCode();
    }

    @Override
    public String toString() {
        return "Administrator" + '\n' +
                "ClubID: " + clubID + '\n'+
                "FirstName: " + firstName + '\n'+
                "LastName: " + lastName+ '\n'+
                "Designation: " + designation+ '\n'+
                "DOB: " + DOB + '\n'+
                "Status: " + status + '\n';
    }
}
