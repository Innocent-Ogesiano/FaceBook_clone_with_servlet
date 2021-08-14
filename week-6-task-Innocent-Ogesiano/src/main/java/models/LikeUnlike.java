package models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LikeUnlike {
    private int like_Id;
    private int post_Id;
    private int user_Id;
}
