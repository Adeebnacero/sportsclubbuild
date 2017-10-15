package com.example.demo.Repository;

import com.example.demo.Domain.ContactDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adeebo on 2017/08/26.
 */
public interface ContactDetailsRepository extends CrudRepository<ContactDetails, Integer>{
}
