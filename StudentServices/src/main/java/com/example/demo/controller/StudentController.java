package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/demo")

public class StudentController {
	@Autowired
    private StudentService studentService;
	@PostMapping("/addstudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }	
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable int id){
        return studentService.fetchStudentById(id);
    }
    @GetMapping("/student")
    public ResponseEntity<?> fetchStudents(){
        return studentService.fetchStudents();
    }
    


}
