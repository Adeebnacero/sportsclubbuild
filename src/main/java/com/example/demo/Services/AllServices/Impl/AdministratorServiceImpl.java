package com.example.demo.Services.AllServices.Impl;

import com.example.demo.Domain.Administrator;
import com.example.demo.Repository.AdministratorRepository;
import com.example.demo.Services.AllServices.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Adeebo on 2017/08/21.
 */
@Component
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator save(Administrator entity) {
        return administratorRepository.save(entity);
    }

    @Override
    public Administrator findById(Integer s) {
        return administratorRepository.findOne(s);
    }

    @Override
    public Administrator update(Integer s) {
        return null;
    }
}
