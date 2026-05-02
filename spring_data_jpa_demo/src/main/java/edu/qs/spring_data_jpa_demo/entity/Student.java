package edu.qs.spring_data_jpa_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	private Integer id;
	
	private String name;
	
	private Double percentgae;
	
	private String gender;
	
	public Student() {
		
	}

	public Student(Integer id, String name, Double percentgae, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.percentgae = percentgae;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercentgae() {
		return percentgae;
	}

	public void setPercentgae(Double percentgae) {
		this.percentgae = percentgae;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
