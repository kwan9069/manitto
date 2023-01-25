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
    private final Boolean archived;
    private final Integer round;
    private static Match instance;

    public Match(Long id, String title, Timestamp matchYmd, Boolean result, Boolean archived, Integer round) {
        this.id = id;
        this.title = title;
        this.matchYmd = matchYmd;
        this.result = result;
        this.archived = archived;
        this.round = round;
        instance = this;
    }

    public InfoDto toInfoDto() {
        instance = this;
        return new InfoDto(id, title, matchYmd, result, archived, round);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        instance = this;
        UpdateDto from = UpdateDto.builder(instance).build();
        if (to.getResult() != null) from.setResult(to.getResult());
        if (to.getArchived() != null) from.setArchived(to.getArchived());
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
    }

    //    @Getter
//    @Setter
//    @Builder
//    @ToString
//    @AllArgsConstructor
//    public static class UpdateDto {
//        @lombok.Builder.Default
//        private Long id = instance.id;
//        @Builder.Default
//        private Boolean result = instance.result;
//        @Builder.Default
//        private Boolean archived = instance.archived;
//    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateDto {

        public static class UpdateDtoBuilder {
            private final Long id;
            private Boolean result;
            private Boolean archived;

            public UpdateDtoBuilder(Match match) {
                id = match.getId();
                result = match.getResult();
                archived = match.getArchived();
            }

            public UpdateDtoBuilder result(Boolean result) {
                this.result = result;
                return this;
            }

            public UpdateDtoBuilder archived(Boolean archived) {
                this.archived = archived;
                return this;
            }

            public UpdateDto build() {
                return new UpdateDto(id, result, archived);
            }

        }

        private Long id;
        private Boolean result;
        private Boolean archived;

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
        private final Boolean archived;
        private final Integer round;
    }
}
