package com.example.manitto.repositories;

import com.example.manitto.dtos.UserMatch;
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
public interface UserMatchRepository {
    void createUserMatch(UserMatch.CreateDto createDto);

    UserMatch getUserMatchByUserIdAndMatchId(@Param("userId") long userId, @Param("matchId") long matchId);

    List<UserMatch> getUserMatchByUserId(@Param("status") String status, @Param("userId") long userId);

    List<UserMatch> getUserMatchByMatchId(@Param("status") String status, @Param("matchId") long matchId);

    Optional<UserMatch.ExtendedDto> getUserMatchExtendedByUserIdAndMatchId(long userId, long matchId);

    Optional<UserMatch.ExtendedDto> getExtendedUserMatchByRound(int round);

    List<UserMatch.ExtendedDto> getExtendedUserMatchList(String status);

    List<UserMatch.ExtendedDto> getExtendedUserMatchListByUserId(@Param("status") String status, @Param("userId") long userId);

    List<UserMatch.ExtendedDto> getExtendedUserMatchListByMatchId(@Param("status") String status, @Param("matchId") long matchId);

    void deleteUserMatch(long id);
}
