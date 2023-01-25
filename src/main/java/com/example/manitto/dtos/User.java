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
        return new InfoDto(id, username, name, email, randomName, role, awareRole, prevContributor, prevReceiver, isAdmin);
    }

    public UpdateDto generateUpdateDto(UpdateDto to) {
        UpdateDto from = UpdateDto.builder().build();
        if (to.getPassword() != null) from.setPassword(to.getPassword());
        if (to.getEmail() != null) from.setEmail(to.getEmail());
        if (to.getRandomName() != null) from.setRandomName(to.getRandomName());
        if (to.getAwareRole() != null) from.setAwareRole(to.getAwareRole());
        if (to.getRole() != null) from.setRole(to.getRole());
        if (to.getPrevContributor() != null) from.setPrevContributor(to.getPrevContributor());
        if (to.getPrevReceiver() != null) from.setPrevReceiver(to.getPrevReceiver());
        return from;
    }

    public UpdateDto generateUpdateDto() {
        return UpdateDto.builder().build();
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
    @Builder
    @ToString
    @AllArgsConstructor
    public static class UpdateDto {
        @lombok.Builder.Default
        private Long id = instance.id;
        @lombok.Builder.Default
        private String password = instance.password;
        @lombok.Builder.Default
        private String email = instance.email;
        @lombok.Builder.Default
        private String randomName = instance.randomName;
        @lombok.Builder.Default
        private String role = instance.role;
        @lombok.Builder.Default
        private Boolean awareRole = instance.awareRole;
        @lombok.Builder.Default
        private Boolean prevContributor = instance.prevContributor;
        @lombok.Builder.Default
        private Boolean prevReceiver = instance.prevReceiver;
    }

    @Getter
    @AllArgsConstructor
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
