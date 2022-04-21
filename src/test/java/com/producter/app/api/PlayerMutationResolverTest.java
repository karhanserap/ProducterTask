package com.producter.app.api;

import com.producter.app.domain.Player;
import com.producter.app.dto.PlayerDto;
import com.producter.app.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PlayerMutationResolverTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
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
        when(playerRepository.save(any(Player.class))).thenReturn(player);
        assertAll("Test for add player",
                () -> assertEquals("Serap",underTest.addPlayer(playerDto).getName()),
                () -> assertEquals("Kok",underTest.addPlayer(playerDto).getSurname()),
                () -> assertEquals(player,underTest.addPlayer(playerDto)));
    }

    @Test
    void deletePlayer() {
        Mockito.doNothing().when(playerRepository).deleteById(anyInt());
        assertEquals("The player deleted from the team.",underTest.deletePlayer(anyInt()));
    }

}