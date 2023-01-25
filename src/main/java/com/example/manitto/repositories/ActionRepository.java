package com.example.manitto.repositories;

import com.example.manitto.dtos.Action;
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
public interface ActionRepository {
    void createAction(Action.CreateDto createDto);

    Optional<Action> getActionById(long id);

    List<Action> getActionListByMatchId(long matchId);
    List<Action> getActionListByType(String type);

    List<Action> getActionListByMatchIdAndType(@Param("matchId") long matchId, @Param("type") String type);

    List<Action> getActionByMatchIdAndTypeLimitDesc(@Param("matchId") long matchId, @Param("type") String type, @Param("limit") int limit);

    void deleteAction(long id);
}
