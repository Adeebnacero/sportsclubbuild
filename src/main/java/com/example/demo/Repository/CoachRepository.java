package com.example.demo.Repository;

import com.example.demo.Domain.Coach;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adeebo on 2017/08/21.
 */
public interface CoachRepository extends CrudRepository<Coach, Integer> {
}
