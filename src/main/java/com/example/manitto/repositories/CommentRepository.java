package com.example.manitto.repositories;

import com.example.manitto.dtos.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.repositories
 */
@Repository
@Mapper
public interface CommentRepository {
    void registerComment(Comment.CreateDto createDto);

    List<Comment> getCommentListByUserId(long userId);

    List<Comment> getCommentListByMatchId(long matchId);

    void udpateComment(Comment.UpdateDto updateDto);

    void deleteComment(long id);

}
