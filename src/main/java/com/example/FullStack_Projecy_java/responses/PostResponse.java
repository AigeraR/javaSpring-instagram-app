package com.example.FullStack_Projecy_java.responses;

import com.example.FullStack_Projecy_java.entities.Post;
import lombok.Data;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;

    public PostResponse(Post entity){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();

    }

}
