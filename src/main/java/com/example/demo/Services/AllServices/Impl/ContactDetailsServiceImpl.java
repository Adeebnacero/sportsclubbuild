package com.example.demo.Services.AllServices.Impl;

import com.example.demo.Domain.ContactDetails;
import com.example.demo.Repository.ContactDetailsRepository;
import com.example.demo.Services.AllServices.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Adeebo on 2017/08/26.
 */
@Component
public class ContactDetailsServiceImpl implements ContactDetailsService {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Override
    public ContactDetails save(ContactDetails entity) {
        return contactDetailsRepository.save(entity);
    }

    @Override
    public ContactDetails findById(Integer s) {
        return contactDetailsRepository.findOne(s);
    }

    @Override
    public ContactDetails update(Integer s) {
        return null;
    }
}
