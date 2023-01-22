package com.example.manitto.dtos;

import lombok.*;

import java.sql.Timestamp;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */

public class Comment {
    private final Long id;
    private final Long userId;
    private final Long matchId;
    private final String content;
    private final String randomName;
    private final Timestamp writtenYmd;
    private final Boolean edited;
    private static Comment instance;

    public Comment(Long id, Long userId, Long matchId, String content, String randomName, Timestamp writtenYmd, Boolean edited) {
        this.id = id;
        this.userId = userId;
        this.matchId = matchId;
        this.content = content;
        this.randomName = randomName;
        this.writtenYmd = writtenYmd;
        this.edited = edited;
        instance = this;
    }


    public InfoDto toInfoDto() {
        return new InfoDto(id, userId, matchId, content, randomName, writtenYmd, edited);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        UpdateDto from = UpdateDto.builder().build();
        if (to.getContent() != null) from.setContent(to.getContent());
        if (to.getEdited() != null) from.setEdited(to.getEdited());
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
        @lombok.Builder.Default
        private Long id = instance.id;
        @Builder.Default
        private String content = instance.content;
        @Builder.Default
        private Boolean edited = instance.edited;
    }

    @Getter
    @AllArgsConstructor
    public static final class InfoDto {
        private final Long id;
        private final Long userId;
        private final Long matchId;
        private final String content;
        private final String randomName;
        private final Timestamp writtenYmd;
        private final Boolean edited;
    }
}
