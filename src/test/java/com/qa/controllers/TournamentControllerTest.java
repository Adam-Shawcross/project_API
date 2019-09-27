package com.qa.controllers;

import com.qa.controller.TournamentController;
import com.qa.models.Tournament;
import com.qa.repository.TournamentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TournamentControllerTest {

    @InjectMocks
    private TournamentController tournamentController;

    @Mock
    private TournamentRepository repository;


    @Test
    public void testGetAllTournaments() {
        List<Tournament> tournamentList = new ArrayList<>();
        Tournament tournament = new Tournament();
        tournament.setId(1L);
        tournament.setName("Worlds");
        tournament.setLocation("Sheffield");
        tournament.setVenue("Ally Pally");
        tournamentList.add(tournament);

        when(repository.findAll()).thenReturn(tournamentList);

        assertEquals(
                tournamentController.listAllTournaments().get(0).getVenue(), "Ally Pally"
        );

        assertEquals(
                Long.toString(tournamentController.listAllTournaments().get(0).getId()), Integer.toString(1)
        );

    }

    @Test
    public void testGetTournament() {

        List<Tournament> tournamentsList = new ArrayList<>();
        Tournament tournament = new Tournament("tourney1","blah","Garage");
        tournamentsList.add(tournament);
        Tournament tournament1 = new Tournament();
        tournament1.setLocation("blah");
        tournament1.setVenue("Ally Pally");
        tournamentsList.add(tournament1);

        when(repository.findOne(1L)).thenReturn(tournamentsList.get(1));

        assertEquals(
                tournamentController.getTournament(1L).getVenue(), "Ally Pally");

    }


    @Test
    public void testAddTournament() {
        List<Tournament> tournamentsList = new ArrayList<>();
        Tournament tournament = new Tournament();
        tournament.setLocation("blah");
        tournament.setVenue("home");
        tournament.setName("worlds");
        tournament.setId(0L);
        tournamentsList.add(tournament);

        Tournament tournament1 = new Tournament();
        tournament1.setLocation("blah");
        tournament1.setVenue("home");
        tournament1.setName("Masters");


        when(repository.saveAndFlush(tournament1)).thenReturn(tournament1);
        assertEquals(tournamentController.addTournament(tournament1).getName(), "Masters");
    }

    @Test
    public void testDeleteTournament() {
        List<Tournament> tournamentsList = new ArrayList<>();
        Tournament tournament = new Tournament();
        tournament.setLocation("blah");
        tournament.setVenue("home");
        tournamentsList.add(tournament);

        when(repository.findOne(0L)).thenReturn(tournamentsList.get(0));
        assertEquals(
                tournamentController.deleteTournament(0L).getLocation(), "blah");
    }


}
