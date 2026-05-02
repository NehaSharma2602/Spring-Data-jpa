package edu.qs.spring_data_jpa_demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomQueryDemo {

	@Autowired
	StudentRepository sRepo;
	
	@GetMapping("/cq/findall")
	public List<Student> findAllStudent() {
		return sRepo.findAll();
	}
	
	@GetMapping("/cq/findallname")
	public List<String> findAllStudentName() {
		return sRepo.fillAllNames();
	}
	
	@GetMapping("/cq/findallnamepercentgae")
	public List<Object[]> findAllStudentNameAndPercentgae() {
		return sRepo.findAllNameAndPercentgae();
	}
	
	@GetMapping("/cq/{name}/gender/{gender}")
	public List<Student> findStudentByNameAndGender(@PathVariable String name,@PathVariable String gender) {
		return sRepo.findStudentByNameandGender(name, gender);
	}
	
	@GetMapping("/cq/")
	public List<Student> findStudentBetweenPerc(@RequestParam double perc1,
	        @RequestParam double perc2) {
		return sRepo.findStudentBetweenPercentgae1(perc1, perc2);
	}
}
