package com.example.FullStack_Projecy_java.servic;

import com.example.FullStack_Projecy_java.entities.Post;
import com.example.FullStack_Projecy_java.entities.User;
import com.example.FullStack_Projecy_java.repost.PostRepository;
import com.example.FullStack_Projecy_java.request.PostCreateRequest;
import com.example.FullStack_Projecy_java.request.PostUpdateRequest;
import com.example.FullStack_Projecy_java.responses.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;
    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<PostResponse> getAllPost(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()){
            list = postRepository.findByUserId(userId.get());
        }
        list=  postRepository.findAll();
        return list.stream().map(p->new PostResponse(p)).collect(Collectors.toList());
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUser(newPostRequest.getUserId());
        if (user == null) {
            return null;
        }
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post updateOnePost(Long postId,PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        else{
            return null;
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}










