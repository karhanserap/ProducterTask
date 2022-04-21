package com.producter.app.api;

import com.producter.app.constants.AppConstants;
import com.producter.app.domain.Player;
import com.producter.app.dto.PlayerDto;
import com.producter.app.enums.ResponseCode;
import com.producter.app.repository.PlayerRepository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerRepository playerRepository;

    public Player addPlayer(PlayerDto playerDto) {
        return  playerRepository.save(dtoToEntity(playerDto));
    }

    public String deletePlayer(int id) {
        playerRepository.deleteById(id);
        return ResponseCode.DELETED_PLAYER_INFO.getMessage();
    }

    private Player dtoToEntity(PlayerDto playerDto) {
        if(playerDto.getPlayerName().trim().isEmpty() || playerDto.getPlayerSurname().trim().isEmpty() ||playerDto.getPositionName().trim().isEmpty())
            throw new GraphQLException(ResponseCode.INVALID_REQUEST.getMessage());
        if (!(AppConstants.TEAM_CAPACITY > playerRepository.findAll().size()))
            throw new GraphQLException(ResponseCode.TEAM_CAPACITY_ERROR.getMessage());
        Player player = new Player();
        player.setName(playerDto.getPlayerName());
        player.setSurname(playerDto.getPlayerSurname());
        if (!AppConstants.POSITION_LIST.contains(playerDto.getPositionName())) {
            throw new GraphQLException(ResponseCode.POSITION_ERROR.getMessage());
        }
        player.setPosition(playerDto.getPositionName());
        return player;
    }

}
