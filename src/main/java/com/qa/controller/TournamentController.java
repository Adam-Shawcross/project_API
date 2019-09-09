package com.qa.controller;

import com.qa.models.Tournament;
import com.qa.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class TournamentController {




    @Autowired
    private TournamentRepository repository;

    @RequestMapping(value="tournaments", method= RequestMethod.GET)
    public List<Tournament> listAllTournaments(){
        return repository.findAll();
    }
    @RequestMapping(value="tournaments", method = RequestMethod.POST)
    public Tournament addTournament(@RequestBody Tournament Tournament){
        return repository.saveAndFlush(Tournament);
    }

    @RequestMapping(value ="tournaments/{id}", method = RequestMethod.GET)
    public Tournament getTournament(@PathVariable Long id){
        return repository.findOne(id);

    }
    @RequestMapping(value="tournaments/{id}", method = RequestMethod.DELETE)
    public Tournament deleteTournament(@PathVariable Long id){
        Tournament existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
    @Transactional
    @RequestMapping(value="tournaments/{id}", method = RequestMethod.PUT)
    public Tournament updateTournament(@PathVariable long id, @RequestBody Tournament tournament){
    Tournament existing = repository.findOne(id);
    existing.setTournament(tournament);
    return existing;
    }
}
