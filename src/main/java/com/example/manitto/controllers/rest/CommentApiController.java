package com.example.manitto.controllers.rest;

import com.example.manitto.dtos.Comment;
import com.example.manitto.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/25,
 * Package : com.example.manitto.controllers.rest
 */
@RestController
@RequestMapping ("/api/comment")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;
    

    @PostMapping("/create")
    public void createComment(Comment.CreateDto createDto)  {
    		commentService.createComment(createDto);
    }

    @GetMapping("/{matchId}")
    public List<Comment.InfoDto> getCommentListByMatchId(@PathVariable long matchId){
        return commentService.getCommentLisBtMatchId(matchId);
    }
}
