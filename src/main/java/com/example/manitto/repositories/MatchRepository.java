package com.example.manitto.repositories;

import com.example.manitto.dtos.Match;
import com.example.manitto.dtos.UserMatch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.repositories
 */
@Repository
@Mapper
public interface MatchRepository {
    void createMatch(Match.CreateDto createDto);

    Match getMatchById(long id);

    List<Match> getMatchByRound(int round);

    List<Match> getAllMatchList();

    List<Match> getMatchListActivated();

    List<Match> getMatchListArchived();

    void updateUserMatch(UserMatch.UpdateDto updateDto);

    void deleteUser(long id);
}
