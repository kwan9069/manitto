package com.example.manitto.dtos;

import lombok.*;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */

public class Action {
    private final Long id;
    private final Long matchId;
    private final String task;
    private final Integer recommendation;
    private final String type;
    private static Action instance;

    public Action(Long id, Long matchId, String task, Integer recommendation, String type) {
        this.id = id;
        this.matchId = matchId;
        this.task = task;
        this.recommendation = recommendation;
        this.type = type;
        instance = this;
    }

    public InfoDto toInfoDto() {
        return new InfoDto(id, matchId, task, recommendation, type);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        UpdateDto from = UpdateDto.builder().build();
        if (to.getRecommendation() != null) from.setRecommendation(to.getRecommendation());
        return from;
    }

    public UpdateDto generateUpdateDto() {
        return UpdateDto.builder().build();
    }


    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final String task;
        private final String type;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class UpdateDto {
        @Builder.Default
        private Integer recommendation = instance.recommendation;
    }

    @Getter
    @AllArgsConstructor
    public static final class InfoDto {
        private final Long id;
        private final Long matchId;
        private final String task;
        private final Integer recommendation;
        private final String type;
    }
}
