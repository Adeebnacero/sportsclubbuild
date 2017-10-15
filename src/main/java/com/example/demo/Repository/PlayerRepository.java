package com.example.demo.Repository;

import com.example.demo.Domain.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Adeebo on 2017/08/21.
 */
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
