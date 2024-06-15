package com.gopi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.bean.Student;

@RestController  // it is the combination of @Controller and @ResponseBody
public class StudentController {

	//http://localhost:8080/student
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student = new  Student("Gopichandu" , 102 , "gopi@gmail.com" , "9989204279");;
		return new ResponseEntity<>(student , HttpStatus.OK);
	}
	
	//http://localhost:8080/students   -- it will return the list of students
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/student/students")
	public List<Student> getStudents() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Gopichandu" , 102 , "gopi@gmail.com" , "9989204279"));
		list.add(new Student("Tirumala" , 102 , "tirumala@gmail.com" , "457845587"));
		list.add(new Student("boddu" , 102 , "boddu@gmail.com" , "1455477788"));
		return list;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/student/{rno}")
	public Student getStudentpathVarible(@PathVariable("rno") int studentRno ){
		return new Student("boddu" , studentRno , "boddu@gmail.com" , "1455477788");
		
	}
	
	//http://localhost:8080/student/query?name=Gopi&rno=1222&emailId=gopiii@gmaiul.com&mobileNo=02155555
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/student/query")
	public Student getStudentQueryParam(@RequestParam String name  , @RequestParam int rno , @RequestParam String emailId, @RequestParam String mobileNo){
		return new Student(name , rno , emailId ,mobileNo);
	}
	
	
	//http://localhost:8080/student/create
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/student/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student);
		return student;
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/student/update/")
	public String updateStudent(@RequestBody Student student) {
		System.out.println(student);
		return "Student Successfully Updated";
		
	}
	
		
	
	
	
}
