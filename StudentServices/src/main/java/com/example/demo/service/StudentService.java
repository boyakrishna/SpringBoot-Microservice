package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.School;
import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
    private StudentRepository studentrepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createStudent(Student student){
        try{
            return new ResponseEntity<Student>(studentrepository.save(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*public String getSchoolData() {
        try {
            return restTemplate.getForObject("http://localhost:8082/school1", String.class);
        } catch (HttpClientErrorException.NotFound e) {
            // Log and handle the 404 error, return a fallback message
            System.err.println("Resource not found: " + e.getMessage());
            return "School resource not found";
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println("Error fetching school data: " + e.getMessage());
            return "Error retrieving school data";
        }
    }*/

    public ResponseEntity<?> fetchStudentById(int id){
        Optional<Student> student =  studentrepository.findById(id);
        if(student.isPresent()){
            School school = restTemplate.getForObject("http://localhost:8085/api/school/get" + student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchStudents(){
        List<Student> students = studentrepository.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }
   

	

}
