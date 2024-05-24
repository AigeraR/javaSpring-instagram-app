package com.example.FullStack_Projecy_java.repost;

import com.example.FullStack_Projecy_java.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
