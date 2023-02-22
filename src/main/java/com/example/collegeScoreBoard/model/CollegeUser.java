package com.example.collegeScoreBoard.model;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CollegeUser {

    @Id
    private int userId;
    private String username;
    private String password;
    private String role;


}
