package edu.qs.spring_data_jpa_demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutomaticCustomQueryController {

	@Autowired
	StudentRepository sRepo;
	
	@GetMapping("/name/{name}")
	public Student findByStudentName(@PathVariable String name) {
		return sRepo.findByName(name);
	}
	
	@GetMapping("/gender/{gender}")
	public List<Student> findByStudentGender(@RequestParam String gender) {
		return sRepo.findByGender(gender);
	}
	@GetMapping("/name/{name}/percentage/{percentgae}")
	public List<Student> findByStudentNameandPercentage(@PathVariable String name, @PathVariable Double percentgae ) {
		return sRepo.findByNameAndPercentgae(name, percentgae);
	}
	
	@GetMapping("/percentage/{percentgae}")
	public List<Student> findByStudentPercentageGreaterthan(@PathVariable Double percentgae ) {
		return sRepo.findByPercentgaeGreaterThan(percentgae);
	}
	
	@GetMapping("/percentage/{percentgae1}/{percentgae2}")
	public List<Student> findByStudentPercentageBetween(@PathVariable Double percentgae1, @PathVariable Double percentgae2 ) {
		return sRepo.findByPercentgaeBetween(percentgae2, percentgae1);
	}
	
	@GetMapping("/gender1/{gender}")
	public int countByGender(@PathVariable String gender ) {
		return sRepo.countByGender(gender);
	}
	
	
	
	
	
}
