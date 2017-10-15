package com.example.demo.Services.AllServices.Impl;

import com.example.demo.Domain.Coach;
import com.example.demo.Repository.CoachRepository;
import com.example.demo.Services.AllServices.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Adeebo on 2017/08/21.
 */
@Component
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public Coach save(Coach entity) {
        return coachRepository.save(entity);
    }

    @Override
    public Coach findById(Integer s) {
        return coachRepository.findOne(s);
    }

    @Override
    public Coach update(Integer s) {
        return null;
    }
}
