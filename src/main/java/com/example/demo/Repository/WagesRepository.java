package com.example.demo.Repository;

import com.example.demo.Domain.Wages;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adeebo on 2017/09/09.
 */
public interface WagesRepository extends CrudRepository<Wages, Integer> {
}
