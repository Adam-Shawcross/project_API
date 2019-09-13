package com.qa.controller;


import com.qa.models.Player;
import com.qa.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerRepository repository;

    @RequestMapping(value = "players", method = RequestMethod.GET)
    public List<Player> listAllPlayers() {
        return repository.findAll();
    }

    @RequestMapping(value = "players", method = RequestMethod.POST)
    public Player addPlayer(@RequestBody Player player) {
        return repository.saveAndFlush(player);
    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable Long id) {
        return repository.findOne(id);

    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.DELETE)
    public Player deletePlayer(@PathVariable Long id) {
        Player existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "players/{id}", method = RequestMethod.PUT)
    public Player updatePlayer(@PathVariable long id, @RequestBody Player player) {
        Player existing = repository.findOne(id);
        existing.setPlayer(player);
        return existing;
    }
}
