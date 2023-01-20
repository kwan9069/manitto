package com.example.manitto.dtos;

import lombok.*;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.dtos
 */

@Getter
@Setter
@RequiredArgsConstructor()
public class UserDto {
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String randomName;
    @NonNull
    private Boolean awareRole;
    private Boolean prevContributor;
    @NonNull
    private Boolean prevReceiver;
    @NonNull
    private Boolean isAdmin;
    private UserDto instance = this;

    public Info toInfoDto() {
        return new Info(getId(), getUsername(), getName(), getEmail(), getRandomName(), getAwareRole(), getPrevContributor(), getPrevContributor(), getIsAdmin());
    }

    public Update toUpdateDto(Update update) {
        Update target = new Update();
        if (update.getPassword() != null) target.setPassword(update.getPassword());
        if (update.getEmail() != null) target.setEmail(update.getEmail());
        if (update.getRandomName() != null) target.setRandomName(update.getRandomName());
        if (update.getAwareRole() != null) target.setAwareRole(update.getAwareRole());
        if (update.getPrevContributor() != null) target.setPrevContributor(update.getPrevContributor());
        if (update.getPrevReceiver() != null) target.setPrevReceiver(update.getPrevReceiver());
        return target;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static final class Auth {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static final class Register {
        private String username;
        private String password;
        private String name;
        private final String email;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class Update {
        private String password;
        private String email;
        private String randomName;
        private Boolean awareRole;
        private Boolean prevContributor;
        private Boolean prevReceiver;

        public Update() {
            this.password = instance.getPassword();
            this.email = instance.getEmail();
            this.randomName = instance.getRandomName();
            this.awareRole = instance.getAwareRole();
            this.prevContributor = instance.getPrevContributor();
            this.prevReceiver = instance.getPrevReceiver();
        }
    }

    @Getter
    @AllArgsConstructor
    public class Info {
        private final long id;
        private final String username;
        private final String name;
        private final String email;
        private final String randomName;
        private final Boolean awareRole;
        private final Boolean prevContributor;
        private final Boolean prevReceiver;
        private final Boolean isAdmin;
    }
}
