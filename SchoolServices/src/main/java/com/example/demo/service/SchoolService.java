package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
@Service
public class SchoolService {
	@Autowired
	private SchoolRepository schoolrepository;
	
	public School addSchool(School school) {
		return schoolrepository.save(school);
	}
	public List<School> fetchSchools(){
		return schoolrepository.findAll();
	}
	public School fetchSchoolById(int id) {
		return schoolrepository.findById(id).orElse(null);
	}

}
