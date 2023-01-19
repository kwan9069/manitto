package com.example.manitto.dtos;

import lombok.*;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */

@Getter
@RequiredArgsConstructor
public class User {
    private final Long id;
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String randomName;
    private final boolean awareRole;
    private final boolean prevContributor;
    private final boolean prevReceiver;
    private final boolean isAdmin;
    User instance = this;

    public User.InfoDto toInfoDto() {
        return new InfoDto(getId(), getUsername(), getName(), getEmail(), getRandomName(), isAwareRole(), isPrevContributor(), isPrevReceiver(), isAdmin());
    }

    public User.UpdateDto toUpdateDto() {
        return new UpdateDto();
    }

    @Getter
    @RequiredArgsConstructor
    public static final class AuthenticationDto {
        private final String username;
        private final String password;
    }

    @Getter
    @RequiredArgsConstructor
    public static final class RegisterDto {
        private final String username;
        private final String password;
        private final String name;
        private final String email;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public class UpdateDto {
        private String password;
        private String email;
        private String randomName;
        private boolean awareRole;
        private boolean prevContributor;
        private boolean prevReceiver;

        public UpdateDto() {
            this.password = instance.getPassword();
            this.email = instance.getEmail();
            this.randomName = instance.getRandomName();
            this.awareRole = instance.isAwareRole();
            this.prevContributor = instance.isPrevContributor();
            this.prevReceiver = instance.isPrevReceiver();
        }
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public class InfoDto {
        private final long id;
        private final String username;
        private final String name;
        private final String email;
        private final String randomName;
        private final boolean awareRole;
        private final boolean prevContributor;
        private final boolean prevReceiver;
        private final boolean isAdmin;
    }
}
