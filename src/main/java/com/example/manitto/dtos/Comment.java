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
public class Comment {
    private final Long id;
    private final Long userId;
    private final Long matchId;
    private final String content;
    private final String writer;
    private final Timestamp writtenYmd;
    private final Boolean edited;
    private static Comment instance;

    public Comment(Long id, Long userId, Long matchId, String content, String writer, Timestamp writtenYmd, Boolean edited) {
        this.id = id;
        this.userId = userId;
        this.matchId = matchId;
        this.content = content;
        this.writer = writer;
        this.writtenYmd = writtenYmd;
        this.edited = edited;
        instance = this;
    }


    public InfoDto toInfoDto() {
        instance = this;
        return new InfoDto(id, userId, matchId, content, writer, writtenYmd, edited);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        instance = this;
        UpdateDto from = UpdateDto.builder(instance).build();
        if (to.getContent() != null) from.setContent(to.getContent());
        if (to.getEdited() != null) from.setEdited(to.getEdited());
        return from;
    }

    public UpdateDto generateUpdateDto(Comment comment) {
        instance = this;
        return UpdateDto.builder(comment).build();
    }


    @Getter
    @RequiredArgsConstructor
    public static final class CreateDto {
        private final Long userId;
        private final Long matchId;
        private final String writer;
        private final String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateDto {

        public static class UpdateDtoBuilder {
            private final Long id;
            private String content;
            private Boolean edited;

            public UpdateDtoBuilder(Comment comment) {
                id = comment.getId();
                content = comment.getContent();
                edited = comment.getEdited();
            }

            public UpdateDtoBuilder content(String content) {
                this.content = content;
                return this;
            }

            public UpdateDtoBuilder edited(Boolean edited) {
                this.edited = edited;
                return this;
            }

            public UpdateDto build() {
                return new UpdateDto(id, content, edited);
            }
        }

        private Long id;
        private String content;
        private Boolean edited;

        public static UpdateDtoBuilder builder(Comment comment) {
            return new UpdateDtoBuilder(comment);
        }
    }

    @Getter
    @AllArgsConstructor
    public static final class InfoDto {
        private final Long id;
        private final Long userId;
        private final Long matchId;
        private final String content;
        private final String writer;
        private final Timestamp writtenYmd;
        private final Boolean edited;
    }
}
