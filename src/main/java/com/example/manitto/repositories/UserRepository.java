package com.example.manitto.repositories;

import com.example.manitto.dtos.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.repositories
 */
@Repository
@Mapper
public interface UserRepository {
    void registerUser(User.RegisterDto registerDto);

    User getUserByUsername(String username);
//
//    User getUserById(long id);
//
//    List<User> getAllUserList();
//
//    List<User> getUserListHavePrevMatch();
//
//    List<User> getUserListByRole(String role);

    void updateUser(User.UpdateDto updateDto);
//
//    void deleteUser(long id);
}
