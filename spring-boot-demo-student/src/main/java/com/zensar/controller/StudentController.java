package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.controller.service.StudentService;
import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;

@RestController
@RequestMapping(value="/student-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class StudentController {

	@Autowired
	private StudentService studentService;

	// http://localhost:8080/students/1001 GET
	// @RequestMapping(value = "/students/{studentId}",method=RequestMethod.GET)
	@GetMapping(value = "/students/{studentId}")
	/* public Student getStudent(@PathVariable("studentId") int studentId) { */
		public StudentDto getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudent(studentId);
	}

	// http://localhost:8080/students
	// @RequestMapping(value = { "/students", "/listOfStudents"
	// },method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listOfStudents" })
	public List<StudentDto> getAllStudents() {
		return studentService.getAllStudents();
	}

	// http://localhost:8080/students POST
	// @RequestMapping(value = "/students",method=RequestMethod.POST)
	@PostMapping(value = "/students")
	/* public void insertStudent(@RequestBody Student student) { */
	
	/* public void insertStudent(@RequestBody StudentDto studentDto) { */
	
	/* public Student insertStudent(@RequestBody StudentDto studentDto) { */
	
		/* studentService.insertStudent(studentDto); */
	
		public StudentDto insertStudent(@RequestBody StudentDto studentDto) {
		return studentService.insertStudent(studentDto);

		// System.out.println("HI");
	}

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody StudentDto studentDto) {
		studentService.updateStudent(studentId, studentDto);

	}

	// http://localhost:8080/students/1001 -> Delete
	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
	}

}