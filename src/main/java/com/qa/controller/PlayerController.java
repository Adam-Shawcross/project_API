package com.qa.controller;


import com.qa.models.Player;
import com.qa.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerRepository repository;

    @RequestMapping(value="players", method= RequestMethod.GET)
  public List<Player> listAllNotes(){
        return repository.findAll();
    }

}
