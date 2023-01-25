package com.example.manitto.dtos;

import lombok.*;

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
        return new InfoDto(id, userId, matchId, isContributor, isReceiver);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        UpdateDto from = UpdateDto.builder().build();
        if (to.getIsContributor() != null) from.setIsContributor(to.getIsContributor());
        if (to.getIsReceiver() != null) from.setIsReceiver(to.getIsReceiver());
        return from;
    }

    public UpdateDto generateUpdateDto() {
        return UpdateDto.builder().build();
    }


    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final Long userId;
        private final Long matchId;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class UpdateDto {
        @lombok.Builder.Default
        private Long id = instance.id;
        @Builder.Default
        private Boolean isContributor = instance.isContributor;
        @Builder.Default
        private Boolean isReceiver = instance.isReceiver;
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
        private final Boolean archived;
        private final Integer round;
    }
}
