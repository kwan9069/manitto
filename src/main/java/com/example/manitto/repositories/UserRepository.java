package com.example.manitto.repositories;

import com.example.manitto.dtos.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.repositories
 */
@Repository
@Mapper
public interface UserRepository {

    boolean isExistUsername(String username);

    boolean isExistEmail(String email);

    void registerUser(User.RegisterDto registerDto);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserById(long id);

    boolean checkAwareRoleById(long id);

    List<User> getAllUserList(int limit);

    List<User> getAllUserListLimit();
    
    int getTotalUser();

    List<User> getUserListHavePrevMatch();

    List<User> getUserListByRole(String role);
    

    void updateUser(User.UpdateDto updateDto);

    void deleteUser(long id);
}
