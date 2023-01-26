package com.example.manitto.repositories;

import com.example.manitto.dtos.Match;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.repositories
 */
@Repository
@Mapper
public interface MatchRepository {
    void createMatch(Match.CreateDto createDto);

    Optional<Match> getMatchById(long id);

    List<Match> getMatchByRound(int round);

    List<Match> getAllMatchList();

    List<Match> getMatchListActive();

    List<Match> getMatchListArchived();
    List<Match> getMatchListWaiting();

    void updateMatch(Match.UpdateDto updateDto);

    void deleteMatch(long id);

    Optional<Match> getMatchByTitle(String title);
}
