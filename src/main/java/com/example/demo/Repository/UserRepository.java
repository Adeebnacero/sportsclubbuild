package com.example.demo.Repository;

import com.example.demo.Domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adeebo on 2017/08/20.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
