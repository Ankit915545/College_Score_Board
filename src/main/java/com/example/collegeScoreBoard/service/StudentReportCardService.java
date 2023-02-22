package com.example.collegeScoreBoard.service;
import com.example.collegeScoreBoard.model.StudentReportCard;
import com.example.collegeScoreBoard.repository.StudentReportCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentReportCardService {

    @Autowired
    StudentReportCardRepository studentReportCardRepositoryObject;



    public void addStudentDetails(StudentReportCard studentReportCardObject){
        studentReportCardRepositoryObject.save(studentReportCardObject);

    }

    public Optional<StudentReportCard> findById(int id){
        return studentReportCardRepositoryObject.findById(id);
    }

    public List<StudentReportCard> displayAll(){
        return studentReportCardRepositoryObject.findAll();
    }

    public List<StudentReportCard> findByName(String name){
        return studentReportCardRepositoryObject.findByName(name);
    }

    public void deleteAll(StudentReportCard studentReportCardObject){
        studentReportCardRepositoryObject.deleteAll();
    }
    public void deleteById(int id){
        studentReportCardRepositoryObject.deleteById(id);
    }

    public String update(int id,StudentReportCard studentReportCardObject){
        Optional<StudentReportCard> newStudentReportCardObject=studentReportCardRepositoryObject.findById(id);
        if(newStudentReportCardObject!=null){
            studentReportCardRepositoryObject.deleteById(id);
            studentReportCardRepositoryObject.save(studentReportCardObject);
            return "student details updated";

        }
        return "not updated";

    }
    public List<StudentReportCard> findByBranch(String branch){
        return studentReportCardRepositoryObject.findByBranch(branch);
    }
    public List<StudentReportCard> findBySession(String session){
        return studentReportCardRepositoryObject.findBySession(session);
    }
}
