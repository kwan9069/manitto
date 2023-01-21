package com.example.manitto.repositories;

import com.example.manitto.dtos.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SampleRepository {
    String test1(User.RegisterDto registerDto);
//    String test2(User user);


}
