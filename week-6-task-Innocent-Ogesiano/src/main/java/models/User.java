package models;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    private int userId;
    private String fullName,userName,email,country,password;
    private Date dateOfBirth;
}
