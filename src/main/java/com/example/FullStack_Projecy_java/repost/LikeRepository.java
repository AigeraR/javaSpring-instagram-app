package com.example.FullStack_Projecy_java.repost;

import com.example.FullStack_Projecy_java.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
