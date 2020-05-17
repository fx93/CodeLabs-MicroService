package com.fx.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

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
