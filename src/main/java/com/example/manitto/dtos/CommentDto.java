package com.example.manitto.dtos;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentDto {
    private Long id;
    @NonNull
    private String content;
    @NonNull
    private String randomName;
    private Timestamp writtenYmd;

    public Info toInfo(){
        return new Info(getContent(), getRandomName(), getWrittenYmd());
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public class Generate {
        private String content;
        private String randomName;
    }

    @RequiredArgsConstructor
    public class Info {
        private final String content;
        private final String randomName;
        private final Timestamp writtenYmd;
    }
}
