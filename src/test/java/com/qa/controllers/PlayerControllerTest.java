package com.qa.controllers;


import com.qa.controller.PlayerController;
import com.qa.models.Player;
import com.qa.repository.PlayerRepository;
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
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {


    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerRepository repository;


    @Test
    public void testGetAllPlayers() {
        List<Player> playerList = new ArrayList<>();
        Player player = new Player();
        player.setAge(23L);
        player.setLastName("Spanner");
        player.setFirstName("David");
        playerList.add(player);

        when(repository.findAll()).thenReturn(playerList);

        assertEquals(
                playerController.listAllPlayers().get(0).getFirstName(), "David"
        );

    }

    @Test
    public void testGetPlayer(){

        List<Player> playersList = new ArrayList<>();
        Player player = new Player();
        player.setLastName("blah");
        player.setFirstName("Spanner");
        playersList.add(player);
        Player player1 = new Player();
        player1.setLastName("blah");
        player1.setFirstName("davey");
        playersList.add(player1);

        when(repository.findOne(1L)).thenReturn(playersList.get(1));

        assertEquals(
                playerController.getPlayer(1L).getFirstName(), "davey");

    }







}
