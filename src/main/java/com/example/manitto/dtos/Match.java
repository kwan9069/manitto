package com.example.manitto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */
@Getter
public class Match {
    private final Long id;
    private final String title;
    private final Timestamp matchYmd;
    private final Boolean result;
    private final String status;
    private final Integer round;
    private static Match instance;

    public Match(Long id, String title, Timestamp matchYmd, Boolean result, String status, Integer round) {
        this.id = id;
        this.title = title;
        this.matchYmd = matchYmd;
        this.result = result;
        this.status = status;
        this.round = round;
        instance = this;
    }

    public InfoDto toInfoDto() {
        instance = this;
        return new InfoDto(id, title, matchYmd, result, status, round);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        instance = this;
        UpdateDto from = UpdateDto.builder(instance).build();
        if (to.getResult() != null) from.setResult(to.getResult());
        if (to.getStatus() != null) from.setStatus(to.getStatus());
        return from;
    }

    public UpdateDto generateUpdateDto(Match match) {
        instance = this;
        return UpdateDto.builder(match).build();
    }


    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final String title;
        private final Integer round;
        private final String status;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateDto {

        public static class UpdateDtoBuilder {
            private final Long id;
            private Boolean result;
            private String status;

            public UpdateDtoBuilder(Match match) {
                id = match.getId();
                result = match.getResult();
                status = match.getStatus();
            }

            public UpdateDtoBuilder result(Boolean result) {
                this.result = result;
                return this;
            }

            public UpdateDtoBuilder status(String status) {
                this.status = status;
                return this;
            }

            public UpdateDto build() {
                return new UpdateDto(id, result, status);
            }

        }

        private Long id;
        private Boolean result;
        private String status;

        public static UpdateDtoBuilder builder(Match match) {
            return new UpdateDtoBuilder(match);
        }
    }


    @Getter
    @AllArgsConstructor
    public static final class InfoDto {
        private final Long id;
        private final String title;
        private final Timestamp matchYmd;
        private final Boolean result;
        private final String status;
        private final Integer round;
    }
}
