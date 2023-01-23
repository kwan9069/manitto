package com.example.manitto.dtos;

import lombok.*;

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
        return new InfoDto(id, title, matchYmd, result, archived, round);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        UpdateDto from = UpdateDto.builder().build();
        if (to.getResult() != null) from.setResult(to.getResult());
        if (to.getArchived() != null) from.setArchived(to.getArchived());
        return from;
    }

    public UpdateDto generateUpdateDto() {
        return UpdateDto.builder().build();
    }


    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final String title;
        private final Integer round;
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
        private Boolean result = instance.result;
        @Builder.Default
        private Boolean archived = instance.archived;
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
