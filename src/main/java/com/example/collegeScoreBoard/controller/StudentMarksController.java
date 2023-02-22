package com.example.collegeScoreBoard.controller;


import com.example.collegeScoreBoard.model.StudentMarks;
import com.example.collegeScoreBoard.service.StudentMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentMarksController {

    @Autowired
    StudentMarksService studentMarksServiceObject;

    @PostMapping("/addStudentMarks")
    public String addStudentMarks(@RequestBody StudentMarks studentMarksObject){
        studentMarksServiceObject.addStudentMarks(studentMarksObject);
        return "record added";
    }

    @GetMapping("/displayByIdMarks/{id}")
    public Optional<StudentMarks> findById(@PathVariable int id){
        return studentMarksServiceObject.findById(id);
    }

    @DeleteMapping("/deleteByIdMarks/{id}")
    public String deleteById(@PathVariable int id){
        studentMarksServiceObject.deleteById(id);
        return "marks record deleted";
    }

    @GetMapping("/displayAllMarks")
    public List<StudentMarks> displayAll(){
        return studentMarksServiceObject.displayAllMarks();
    }
    @PutMapping("/updateMarks/{id}")
    public String marksUpdate(@PathVariable int id,@RequestBody StudentMarks studentMarksObject){
        studentMarksServiceObject.updateMarks(id,studentMarksObject);
        return "marks updated";
    }

    @DeleteMapping("/deleteAllMarks")
    public String deleteAllmarks(){
        studentMarksServiceObject.deleteAllMarks();
        return "all record deleted";
    }




}
