package edu.qs.spring_data_jpa_demo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// first one for entity class name and second one for the datatype of primary key of entity class 
public interface StudentRepository extends JpaRepository<Student, Integer> {

	//findBy
	public Student findByName(String name);
	
	public List<Student> findByGender(String gender);
	
	public List<Student> findByNameAndPercentgae(String name, Double percentgae);
	
	public List<Student> findByPercentgaeGreaterThan(Double percentgae);
	
	public List<Student> findByPercentgaeBetween(Double percentgae, Double percentgae1);
	
	//countBy
	
	public int countByGender(String gender);
	
	/*----------------------------------------------------------------------------------------------------------------------*/
	
	@Query("select s from Student s")
	public List<Student> findAllStudent();
	
	@Query("select s.name from Student s")
	public List<String> fillAllNames();
	
	@Query("select s.name, s.percentgae from Student s")
	public List<Object[]> findAllNameAndPercentgae();
	
	
	/*-----------------------------------------------------------------------------------------------------------------------*/
	@Query("select s from Student s where s.name = ?1 and s.gender = ?2")
	public List<Student> findStudentByNameandGender(String name, String gender);
	
	@Query("select s from Student s where s.percentgae between :perc1 and :perc2")
	public List<Student> findStudentBetweenPercentgae1(@Param("perc1") double perc1,@Param("perc2") double perc2
	);
	
	
}
