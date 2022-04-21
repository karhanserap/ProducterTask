package com.producter.app.integration;

import com.producter.app.api.PlayerMutationResolver;
import com.producter.app.api.PlayerQueryResolver;
import com.producter.app.domain.Player;
import com.producter.app.dto.PlayerDto;
import com.producter.app.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PlayerQueryResolverIntegrationTest {

    @Autowired
    private PlayerQueryResolver underTest;

    @Autowired
    private PlayerMutationResolver playerMutationResolver;

    private PlayerDto playerDto;
    private Player player;
    List<Player> players;

    @BeforeEach
    void setUp(){
        playerDto = new PlayerDto();
        playerDto.setPlayerName("Serap");
        playerDto.setPlayerSurname("Kok");
        playerDto.setPositionName("Center");

        player = new Player();
        player.setName("Serap");
        player.setSurname("Kok");
        player.setPosition("Center");
        player.setId(30);

        players = new ArrayList<>();
    }

    @Test
    void getPlayers() {
    Player newPlayer = playerMutationResolver.addPlayer(playerDto);
    assertEquals(1,underTest.getPlayers().size());
    }
}