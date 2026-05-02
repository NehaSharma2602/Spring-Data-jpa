package edu.qs.spring_data_jpa_demo.validation;

import java.time.LocalDate;
import java.util.List;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



public class Student {

	
	@NotNull(message ="id cannot be null")
	private Integer id;
	
	@NotBlank(message = "name cannot be blank")
	private String name;
	
	@NotEmpty(message ="subject cannot be empty")
	private List<String> subject;
	
	@Size(min = 4, max = 8, message="password shoult be min 4 char and max 8 char")
	private String password;
	
	@Email(message ="email should be in valid format")
	@NotBlank(message ="email cannot be black")
	private String email;
	
	@Min(value = 18, message = "min age should be 18")
	@Max(value = 30, message = "max age should be 30")
	private Integer age;
	
	@Positive(message = "percentage should be positive")
	private Double percentage;
	
	@Pattern(
			regexp ="^[6-9][0-9]{9}$",
			message = "phone number should start with 6-9 and should be of 10 digits"
			)
	private Long phone;
	
	@Past(message = "dob should be in past")
	private LocalDate dob;
	
}
