package com.fx.microthree.controller;

import com.fx.microthree.model.Student;
import com.fx.microthree.service.StudentService;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ThirdController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "student", method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok("student added successfully!");
    }

    @RequestMapping(value = "student", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "details/{stdId}", method = RequestMethod.GET)
    public ResponseEntity<Student> fetchDetails(@PathVariable int stdId){
        Optional<Student> student = studentService.fetchDetails(stdId);

        if (student.isPresent()){
            return ResponseEntity.ok().body(student.get());
        }
        else{ return ResponseEntity.notFound().build();}
    }
}
