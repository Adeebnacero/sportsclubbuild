package com.example.demo.Services.AllServices.Impl;

import com.example.demo.Domain.Player;
import com.example.demo.Repository.PlayerRepository;
import com.example.demo.Services.AllServices.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Adeebo on 2017/08/21.
 */
@Component
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;
    protected EntityManager entityManager;

    @Override
    public Player save(Player entity) {
        return playerRepository.save(entity);
    }

    @Override
    public Player findById(Integer s) {
        return playerRepository.findOne(s);
    }

    @Override
    public Player update(Integer s) {
        return null;
    }


}
