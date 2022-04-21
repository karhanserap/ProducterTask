package com.producter.app.integration;

import com.producter.app.api.PlayerMutationResolver;
import com.producter.app.domain.Player;
import com.producter.app.dto.PlayerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PlayerMutationResolverIntegrationTest {

    @Autowired
    private PlayerMutationResolver underTest;

    private PlayerDto playerDto;
    private Player player;

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
    }

    @Test
    void addPlayer() {
        assertEquals(player.getName(),underTest.addPlayer(playerDto).getName());
    }

    @Test
    void deletePlayer() {
        int playerID = underTest.addPlayer(playerDto).getId();
        assertEquals("The player deleted from the team.",underTest.deletePlayer(playerID));

    }

}