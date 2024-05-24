package com.example.FullStack_Projecy_java.controllers;

import com.example.FullStack_Projecy_java.entities.Comment;
import com.example.FullStack_Projecy_java.repost.CommentRepository;
import com.example.FullStack_Projecy_java.request.CommentCreateRequest;
import com.example.FullStack_Projecy_java.request.CommentUpdateRequest;
import com.example.FullStack_Projecy_java.servic.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComment(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
        return  commentService.getAllComments(userId,postId);
    }


    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneComment(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return  commentService.saveOneComment(commentCreateRequest);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateOneCommentById(commentId,commentUpdateRequest);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }


}
