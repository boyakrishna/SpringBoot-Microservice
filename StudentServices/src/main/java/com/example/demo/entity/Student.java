package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
    private int id;
	@Column
	@JsonProperty("name")
    private String name;
	@Column
	@JsonProperty("age")
    private int age;
	@Column
	@JsonProperty("gender")
    private String gender;
	@Column
	@JsonProperty("schoolId")
    private int schoolId;
	public int getSchoolId() {
		// TODO Auto-generated method stub
		return schoolId;
	}
	    public Student() {
	       
	    }

	public Student(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	


}
