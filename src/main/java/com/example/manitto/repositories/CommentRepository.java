package com.example.manitto.repositories;

import com.example.manitto.dtos.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.repositories
 */
@Repository
@Mapper
public interface CommentRepository {
    void createComment(Comment.CreateDto createDto);

    List<Comment> getCommentListByUserId(long userId);
    List<Comment> getCommentListByUserIdLimit(@Param("userId") long userId, @Param("limit") int limit, @Param("offset") int offset);

    List<Comment> getCommentListByMatchId(long matchId);
    List<Comment> getCommentListByMatchIdLimit(@Param("matchId") long matchId, @Param("limit") int limit, @Param("offset") int offset);
    void updateComment(Comment.UpdateDto updateDto);
    void deleteComment(long id);
}
