package com.producter.app.api;

import com.producter.app.domain.Player;
import com.producter.app.dto.PlayerDto;
import com.producter.app.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerQueryResolverTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerQueryResolver underTest;

    private Player player;
    List<Player> players;

    @BeforeEach
    void setUp(){

        player = new Player();
        player.setName("Serap");
        player.setSurname("Kok");
        player.setPosition("Center");
        player.setId(30);

        players = new ArrayList<>();
        players.add(player);
    }

    @Test
    void getPlayers() {
        when(playerRepository.findAll()).thenReturn(players);
        assertEquals(players,underTest.getPlayers());
    }
}