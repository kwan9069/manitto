package com.example.manitto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */

@Getter
public class UserMatch {
    private final Long id;
    private final Long userId;
    private final Long matchId;
    private final Boolean isContributor;
    private final Boolean isReceiver;
    private static UserMatch instance;

    public UserMatch(Long id, Long userId, Long matchId, Boolean isContributor, Boolean isReceiver) {
        this.id = id;
        this.userId = userId;
        this.matchId = matchId;
        this.isContributor = isContributor;
        this.isReceiver = isReceiver;
        instance = this;
    }


    public InfoDto toInfoDto() {
        instance = this;
        return new InfoDto(id, userId, matchId, isContributor, isReceiver);
    }

    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final Long userId;
        private final Long matchId;
        private final Boolean isContributor;
        private final Boolean isReceiver;
    }

    @Getter
    @AllArgsConstructor
    public static final class InfoDto {
        private final Long id;
        private final Long userId;
        private final Long matchId;
        private final Boolean isContributor;
        private final Boolean isReceiver;
    }

    @Getter
    @AllArgsConstructor
    public static final class ExtendedDto {
        private final Long id;
        private final Long userId;
        private final Long matchId;
        private final String username;
        private final String name;
        private final String randomName;
        private final String role;
        private final String title;
        private final Timestamp matchYmd;
        private final Boolean result;
        private final String status;
        private final Integer round;
    }
}
