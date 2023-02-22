package com.example.collegeScoreBoard.service;


import com.example.collegeScoreBoard.model.StudentMarks;
import com.example.collegeScoreBoard.repository.StudentMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentMarksService {

    @Autowired
    StudentMarksRepository studentMarksRepositoryObject;

    public void addStudentMarks(StudentMarks studentMarksObject){
        studentMarksRepositoryObject.save(studentMarksObject);
    }

    public Optional<StudentMarks> findById(int id) {
        return studentMarksRepositoryObject.findById(id);
    }

    public String deleteById(int id){
        studentMarksRepositoryObject.deleteById(id);
        return "marks deleted";
    }

    public String updateMarks(int id,StudentMarks studentMarksObject){
        Optional<StudentMarks> newStudentMarksObject=studentMarksRepositoryObject.findById(id);
        if(newStudentMarksObject!=null){
            studentMarksRepositoryObject.deleteById(id);
            studentMarksRepositoryObject.save(studentMarksObject);
            return "marks updated";
        }
        return "not updated";
    }
    public List<StudentMarks> displayAllMarks(){
        return studentMarksRepositoryObject.findAll();
    }
    public String deleteAllMarks(){
        studentMarksRepositoryObject.deleteAll();
        return "all record deleted";
    }
}
