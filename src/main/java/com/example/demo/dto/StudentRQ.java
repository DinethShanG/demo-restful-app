package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentRQ {
	@NotBlank(message = "Name is required")
	private String name;
}