package com.example.FullStack_Projecy_java.controllers;

import com.example.FullStack_Projecy_java.entities.Post;
import com.example.FullStack_Projecy_java.entities.User;
import com.example.FullStack_Projecy_java.request.PostCreateRequest;
import com.example.FullStack_Projecy_java.request.PostUpdateRequest;
import com.example.FullStack_Projecy_java.responses.PostResponse;
import com.example.FullStack_Projecy_java.servic.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    PostResponse postResponse;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }
    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }
    @PostMapping
    public  Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePost(postId,updatePost);

    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

}













