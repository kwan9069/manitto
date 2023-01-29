package com.example.manitto.services;

import com.example.manitto.dtos.Comment;
import com.example.manitto.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/25,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    
    public void createComment(Comment.CreateDto createDto) {
    		commentRepository.createComment(createDto);
    }

    public List<Comment.InfoDto> getCommentLisBtMatchId(long matchId) {
        return commentRepository.getCommentListByMatchId(matchId).stream().map(Comment::toInfoDto).toList();
    }
}
