package com.example.demo.Domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adeebo on 2017/08/04.
 */
@Entity
public class ContactDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer contactID;
    private Integer clubID;
    private String playerContactNumber;
    private String contactFirstName;
    private String contactLastName;
    private String relationship;
    private String contactHomeNumber;
    private String contactCellphoneNumber;

    public ContactDetails() {
    }

    public ContactDetails(Builder builder){

        this.contactID = builder.contactID;
        this.clubID = builder.clubID;
        this.playerContactNumber = builder.playerContactNumber;
        this.contactFirstName = builder.contactFirstName;
        this.contactLastName = builder.contactLastName;
        this.relationship = builder.relationship;
        this.contactHomeNumber = builder.contactHomeNumber;
        this.contactCellphoneNumber = builder.contactCellphoneNumber;
    }

    public static class Builder{

        private Integer contactID;
        private Integer clubID;
        private String playerContactNumber;
        private String contactFirstName;
        private String contactLastName;
        private String relationship;
        private String contactHomeNumber;
        private String contactCellphoneNumber;

        public Builder setContactID(Integer contactID) {
            this.contactID = contactID;
            return this;
        }

        public Builder setClubID(Integer clubID) {
            this.clubID = clubID;
            return this;
        }

        public Builder setPlayerContactNumber(String playerContactNumber) {
            this.playerContactNumber = playerContactNumber;
            return this;
        }

        public Builder setContactFirstName(String contactFirstName) {
            this.contactFirstName = contactFirstName;
            return this;
        }

        public Builder setContactLastName(String contactLastName) {
            this.contactLastName = contactLastName;
            return this;
        }

        public Builder setRelationship(String relationship) {
            this.relationship = relationship;
            return this;
        }

        public Builder setContactHomeNumber(String contactHomeNumber) {
            this.contactHomeNumber = contactHomeNumber;
            return this;
        }

        public Builder setContactCellphoneNumber(String contactCellphoneNumber) {
            this.contactCellphoneNumber = contactCellphoneNumber;
            return this;
        }

        public Builder copy (ContactDetails value){

            this.contactID = value.contactID;
            this.clubID = value.clubID;
            this.playerContactNumber = value.playerContactNumber;
            this.contactFirstName = value.contactFirstName;
            this.contactLastName = value.contactLastName;
            this.relationship = value.relationship;
            this.contactHomeNumber = value.contactHomeNumber;
            this.contactCellphoneNumber = value.contactCellphoneNumber;

            return this;
        }

        public ContactDetails build(){

            return new ContactDetails(this);
        }
    }

    public Integer getContactID() {
        return contactID;
    }

    public Integer getClubID() {
        return clubID;
    }

    public String getPlayerContactNumber() {
        return playerContactNumber;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getContactHomeNumber() {
        return contactHomeNumber;
    }

    public String getContactCellphoneNumber() {
        return contactCellphoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDetails)) return false;

        ContactDetails contactDetails = (ContactDetails) o;

        return contactFirstName.equals(contactDetails.contactFirstName);

    }

    @Override
    public int hashCode() {
        return contactFirstName.hashCode();
    }

    @Override
    public String toString() {
        return "***ContactDetails***" + '\n' +
                "ConatcID: " + contactID + '\n' +
                "ClubID: " + clubID + '\n' +
                "PlayerContactNumber: " + playerContactNumber + '\n' +
                "ContactFirstName: " + contactFirstName + '\n' +
                "ContactLastName: " + contactLastName + '\n' +
                "Relationship: " + relationship + '\n' +
                "ContactHomeNumber: " + contactHomeNumber + '\n' +
                "ContactCellphoneNumber: " + contactCellphoneNumber + '\n' +
                "******************" + '\n';
    }
}
