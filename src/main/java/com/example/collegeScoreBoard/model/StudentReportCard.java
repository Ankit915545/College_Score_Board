package com.example.collegeScoreBoard.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentReportCard {



    @Id
    private int id;
    private String name;
    private Long rollNo;
    private String collegeName;
    private String branch;
    private String session;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="studentMarksId")
    private StudentMarks studentMarksObject;


}
