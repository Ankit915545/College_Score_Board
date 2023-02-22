package com.example.collegeScoreBoard.repository;


import com.example.collegeScoreBoard.model.StudentReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentReportCardRepository extends JpaRepository<StudentReportCard,Integer> {


    List<StudentReportCard> findByName(String name);


    List<StudentReportCard> findByBranch(String branch);

    List<StudentReportCard> findBySession(String session);
}
