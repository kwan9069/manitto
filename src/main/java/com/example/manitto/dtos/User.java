package com.example.manitto.dtos;

import lombok.*;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */

@Getter
public class User {
    private final Long id;
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String randomName;
    private final String role;
    private final Boolean awareRole;
    private final Boolean prevContributor;
    private final Boolean prevReceiver;
    private final Boolean isAdmin;
    private static User instance;

    public User(Long id, String username, String password, String name, String email, String randomName, String role, Boolean awareRole, Boolean prevContributor, Boolean prevReceiver, Boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.randomName = randomName;
        this.role = role;
        this.awareRole = awareRole;
        this.prevContributor = prevContributor;
        this.prevReceiver = prevReceiver;
        this.isAdmin = isAdmin;
        instance = this;
    }

    public InfoDto toInfoDto() {
        instance = this;
        return new InfoDto(id, username, name, email, randomName, role, awareRole, prevContributor, prevReceiver, isAdmin);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        instance = this;
        UpdateDto from = UpdateDto.builder(instance).build();
        if (to.getPassword() != null) from.setPassword(to.getPassword());
        if (to.getEmail() != null) from.setEmail(to.getEmail());
        if (to.getRandomName() != null) from.setRandomName(to.getRandomName());
        if (to.getAwareRole() != null) from.setAwareRole(to.getAwareRole());
        if (to.getRole() != null) from.setRole(to.getRole());
        if (to.getPrevContributor() != null) from.setPrevContributor(to.getPrevContributor());
        if (to.getPrevReceiver() != null) from.setPrevReceiver(to.getPrevReceiver());
        return from;
    }

    public UpdateDto generateUpdateDto(User user) {
        return UpdateDto.builder(user).build();
    }

    @Getter
    @RequiredArgsConstructor
    public static final class AuthDto {
        private final String username;
        private final String password;
    }

    @Getter
    public static final class RegisterDto {
        private final String username;
        private final String password;
        private final String name;
        private final String email;

        public RegisterDto(String username, String password, String name, String email) {
            this.username = username;
            this.password = BCrypt.hashpw(password, BCrypt.gensalt());
            this.name = name;
            this.email = email;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateDto {

        public static class UpdateDtoBuilder {
            private final Long id;
            private String password;
            private String email;
            private String randomName;
            private String role;
            private Boolean awareRole;
            private Boolean prevContributor;
            private Boolean prevReceiver;

            public UpdateDtoBuilder(User user) {
                id = user.getId();
                password = user.getPassword();
                email = user.getEmail();
                randomName = user.getRandomName();
                role = user.getRole();
                awareRole = user.getAwareRole();
                prevContributor = user.getPrevContributor();
                prevReceiver = user.getPrevReceiver();
            }

            public UpdateDtoBuilder password(String password) {
                this.password = password;
                return this;
            }

            public UpdateDtoBuilder email(String email) {
                this.email = email;
                return this;
            }

            public UpdateDtoBuilder randomName(String randomName) {
                this.randomName = randomName;
                return this;
            }

            public UpdateDtoBuilder role(String role) {
                this.role = role;
                return this;
            }

            public UpdateDtoBuilder awareRole(Boolean awareRole) {
                this.awareRole = awareRole;
                return this;
            }

            public UpdateDtoBuilder prevContributor(Boolean prevContributor) {
                this.prevContributor = prevContributor;
                return this;
            }

            public UpdateDtoBuilder prevReceiver(Boolean prevReceiver) {
                this.prevReceiver = prevReceiver;
                return this;
            }

            public UpdateDto build() {
                return new UpdateDto(id, password, email, randomName, role, awareRole, prevContributor, prevReceiver);
            }

        }

        private Long id;
        private String password;
        private String email;
        private String randomName;
        private String role;
        private Boolean awareRole;
        private Boolean prevContributor;
        private Boolean prevReceiver;

        public static UpdateDtoBuilder builder(User user) {
            return new UpdateDtoBuilder(user);
        }
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static final class InfoDto {
        private final long id;
        private final String username;
        private final String name;
        private final String email;
        private final String randomName;
        private final String role;
        private final Boolean awareRole;
        private final Boolean prevContributor;
        private final Boolean prevReceiver;
        private final Boolean isAdmin;
    }
}
