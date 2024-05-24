package com.example.FullStack_Projecy_java.repost;

import com.example.FullStack_Projecy_java.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
