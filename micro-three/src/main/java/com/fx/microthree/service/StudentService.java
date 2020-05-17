package com.fx.microthree.service;

import com.fx.microthree.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void addStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> fetchDetails(int id);
}
