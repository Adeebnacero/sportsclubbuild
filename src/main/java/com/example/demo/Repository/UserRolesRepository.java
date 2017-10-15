package com.example.demo.Repository;

import com.example.demo.Domain.UserRoles;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adeebo on 2017/08/26.
 */
public interface UserRolesRepository extends CrudRepository<UserRoles, Integer>{
/*
    @Query("select ad.designation from UserRoles ur, Administrator ad where ad.firstName=?1 and ur.clubID=ad.clubID")
    public List<String> findRoleByUserName(String firstName);*/
}
