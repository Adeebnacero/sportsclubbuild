package com.example.demo.Factory;

import com.example.demo.Domain.ContactDetails;

/**
 * Created by Adeebo on 2017/08/26.
 */
public class ContactDetailsFactory {

    public static ContactDetails buildContactDetails(Integer clubID, String playerContactNumber, String contactFirstName, String contactLastName,String relationship,String contactHomeNumber,String contactCellphoneNumber){

        ContactDetails contactDetails = new ContactDetails.Builder()
                .setClubID(clubID)
                .setPlayerContactNumber(playerContactNumber)
                .setContactFirstName(contactFirstName)
                .setContactLastName(contactLastName)
                .setRelationship(relationship)
                .setContactHomeNumber(contactHomeNumber)
                .setContactCellphoneNumber(contactCellphoneNumber)
                .build();
        return contactDetails;
    }
}