package com.example.collegeScoreBoard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class StudentMarks {

    @Id
    private int id;
    private String firstYearPercentage;
    private String secondYearPercentage;
    private String thirdYearPercentage;
    private String fourthYearPercentage;
    private String totalPercentage;



}
