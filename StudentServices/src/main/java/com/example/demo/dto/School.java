package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
	@SuppressWarnings("unused")
	private int id;
    @SuppressWarnings("unused")
	private String schoolName;
    @SuppressWarnings("unused")
	private String location;
    @SuppressWarnings("unused")
	private String principalName;

	

}
