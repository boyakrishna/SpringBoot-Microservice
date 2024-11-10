package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.School;
import com.example.demo.service.SchoolService;

@RequestMapping("/api/school")
@RestController
public class SchoolContoller {
	@Autowired
    private SchoolService schoolservice;

    @PostMapping("/add")
    public School addSchool(@RequestBody School school){
        return schoolservice.addSchool(school);
    }
    @GetMapping("/get")
    public List<School> fetchSchools(){
        return  schoolservice.fetchSchools();
    }
    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable int id){
        return schoolservice.fetchSchoolById(id);
    }


}
