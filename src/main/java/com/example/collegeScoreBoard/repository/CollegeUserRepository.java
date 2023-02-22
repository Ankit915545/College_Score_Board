package com.example.collegeScoreBoard.repository;


import com.example.collegeScoreBoard.model.CollegeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeUserRepository extends JpaRepository<CollegeUser,Integer> {
    CollegeUser findByUsername(String username);
}
