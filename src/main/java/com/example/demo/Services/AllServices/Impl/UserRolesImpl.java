package com.example.demo.Services.AllServices.Impl;

import com.example.demo.Domain.UserRoles;
import com.example.demo.Repository.UserRolesRepository;
import com.example.demo.Services.AllServices.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Adeebo on 2017/09/06.
 */
@Component
public class UserRolesImpl implements UserRoleService{

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public UserRoles save(UserRoles entity) {
        return userRolesRepository.save(entity);
    }

    @Override
    public UserRoles findById(Integer s) {
        return userRolesRepository.findOne(s);
    }

    @Override
    public UserRoles update(Integer s) {
        return null;
    }

}
