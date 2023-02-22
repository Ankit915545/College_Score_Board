package com.example.collegeScoreBoard.controller;


import com.example.collegeScoreBoard.model.StudentMarks;
import com.example.collegeScoreBoard.model.StudentReportCard;
import com.example.collegeScoreBoard.service.StudentReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentReportCardController {

    @Autowired
    StudentReportCardService studentReportCardServiceObject;

    @PostMapping("/addStudentDetails")
    public String addStudentDetails(@RequestBody StudentReportCard studentReportCardObject){
        studentReportCardServiceObject.addStudentDetails(studentReportCardObject);
        return "record added";
    }


    @GetMapping("/displayById/{id}")
    public Optional<StudentReportCard> findById(@PathVariable int id){
        return studentReportCardServiceObject.findById(id);
    }

    @GetMapping("/displayByName/{name}")
    public List<StudentReportCard> findByName(@PathVariable String name){
        return studentReportCardServiceObject.findByName(name);

    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id){
        studentReportCardServiceObject.deleteById(id);
        return "record deleted";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(@RequestBody StudentReportCard studentReportCardObject){
        studentReportCardServiceObject.deleteAll(studentReportCardObject);
        return "all record deleted";
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id,@RequestBody StudentReportCard studentReportCardObject){
        studentReportCardServiceObject.update(id,studentReportCardObject);
        return "updated";
    }

    @GetMapping("/displayAll")
    public List<StudentReportCard> displayAll(){
        return studentReportCardServiceObject.displayAll();
    }

    @GetMapping("/displayByBranch/{branch}")
    public List<StudentReportCard> displayByBranch(@PathVariable String branch){
        return studentReportCardServiceObject.findByBranch(branch);
    }

    @GetMapping("/displayBySession/{session}")
    public List<StudentReportCard> displayBySession(@PathVariable String session){
        return studentReportCardServiceObject.findBySession(session);
    }


}
