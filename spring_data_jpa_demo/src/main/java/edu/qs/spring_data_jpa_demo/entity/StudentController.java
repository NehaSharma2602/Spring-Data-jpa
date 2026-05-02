package edu.qs.spring_data_jpa_demo.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentRepository sRepo;
	
	@PostMapping("/add")
	public String saveStudent(@RequestBody Student student) {
		sRepo.save(student);
		return "student added";
	}
	
	@PostMapping("/addall")
	public String saveAllStudent(@RequestBody List<Student> student) {
		sRepo.saveAll(student);
		return "student added";
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		 Optional<Student> opt = sRepo.findById(id); // option will handle the null pointer method
		 if(opt.isPresent()) {
			 return opt.get();
		 }
		return null;
	}
	
	@GetMapping("/find")
	public List<Student> findAllStudent(){
		return sRepo.findAll();
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student s) {
		sRepo.save(s);
		
		return "student updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable int id) {
		 Optional<Student> opt = sRepo.findById(id);
		 if(opt.isPresent()) {
			 sRepo.deleteById(id);
		 }
		return "Student deleted";
	}
	
	
	
}
