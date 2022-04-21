package com.producter.app.enums;

import lombok.Getter;

public enum ResponseCode {

    POSITION_ERROR("Invalid position"),
    TEAM_CAPACITY_ERROR("Team capacity should be a maximum of 12 person."),
    DELETED_PLAYER_INFO("The player deleted from the team."),
    INVALID_REQUEST("Player name, surname and position fields are required."),;

    @Getter
    private String message;

    ResponseCode(String message) {
        this.message = message;
    }

}
