package com.example.collegeScoreBoard.repository;


import com.example.collegeScoreBoard.model.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks,Integer> {
}
