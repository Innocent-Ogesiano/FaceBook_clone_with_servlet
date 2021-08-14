package models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private int postId;
    private User user;
    private String post;
    private int likes;
}
