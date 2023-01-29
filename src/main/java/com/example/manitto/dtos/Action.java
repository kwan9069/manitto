package com.example.manitto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */
@Getter
public class Action {
    private final Long id;
    private final String type;
    private final Long matchId;
    private final String task;
    private final Integer recommendation;
    private static Action instance;

    public Action(Long id, String type, Long matchId, String task, Integer recommendation) {
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
        instance = this;
        UpdateDto from = UpdateDto.builder(instance).build();
        if (to.getRecommendation() != null) from.setRecommendation(to.getRecommendation());
        return from;
    }

    public UpdateDto generateUpdateDto(Action action) {
        return UpdateDto.builder(action).build();
    }


    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final Long matchId;
        private final String task;
        private final String type;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateDto {

        private static class UpdateDtoBuilder {
            private final Long id;
            private Integer recommendation;

            public UpdateDtoBuilder(Action action) {
                id = action.getId();
                recommendation = action.getRecommendation();
            }

            public UpdateDtoBuilder recommendation(Integer recommendation) {
                this.recommendation = recommendation;
                return this;
            }

            public UpdateDto build() {
                return new UpdateDto(id, recommendation);
            }

        }

        private Long id;
        private Integer recommendation;

        public static UpdateDtoBuilder builder(Action action) {
            return new UpdateDtoBuilder(action);
        }
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
