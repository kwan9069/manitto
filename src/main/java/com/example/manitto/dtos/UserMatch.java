package com.example.manitto.dtos;

import lombok.*;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */


public class UserMatch {
    private final Long userId;
    private final Long matchId;
    private final Boolean isDonator;
    private final Boolean isReceiver;
    private static UserMatch instance;

    public UserMatch(Long userId, Long matchId, Boolean isDonator, Boolean isReceiver) {
        this.userId = userId;
        this.matchId = matchId;
        this.isDonator = isDonator;
        this.isReceiver = isReceiver;

        instance = this;
    }


    public InfoDto toInfoDto() {
        return new InfoDto(userId, matchId, isDonator, isReceiver);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        UpdateDto from = UpdateDto.builder().build();
        if (to.getIsDonator() != null) from.setIsDonator(to.getIsDonator());
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
        private final String content;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class UpdateDto {
        @Builder.Default
        private Boolean isDonator = instance.isDonator;
        @Builder.Default
        private Boolean isReceiver = instance.isReceiver;
    }

    @Getter
    @AllArgsConstructor
    public static final class InfoDto {
        private final Long userId;
        private final Long matchId;
        private final Boolean isDonator;
        private final Boolean isReceiver;
    }
}
