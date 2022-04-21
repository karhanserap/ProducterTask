package com.producter.app.api;


import com.producter.app.domain.Player;
import com.producter.app.repository.PlayerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerRepository playerRepository;

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

}
