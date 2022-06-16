package com.zensar.controller.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.controller.repository.StudentRepository;
import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;



@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	/* public Student getStudent(int studentId) { */
	public StudentDto getStudent(int studentId) {
		Student student=studentRepository.findById(studentId).get();
		//StudentDto dto =mapToDto(student);
		
	return	modelMapper.map(student, StudentDto.class);
		//return dto;
		
		/* return studentRepository.findById(studentId).get(); 
		 * StudentDto dto=new StudentDto(); dto.setStudentId(student.getStudentId());
		 * dto.setStudentName(student.getStudentName());
		 * dto.setStudentAge(student.getStudentAge()); return dto;
		 */
		
		 
		
	}

	@Override
	public List<StudentDto> getAllStudents() {
		/* return studentRepository.findAll(); */
		
		List<Student> listOfStudents =studentRepository.findAll();
		List<StudentDto> listOfStudentsDto=new ArrayList<StudentDto>();
		
		for(Student student:listOfStudents) {
			//listOfStudentsDto.add(mapToDto(student));
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentsDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		
		/*
		 * Student student=new Student(); student.setStudentId(student.getStudentId());
		 * student.setStudentName(student.getStudentName());
		 * student.setStudentAge(student.getStudentAge());
		 */
		
		//Student student=mapToEntity(studentDto);
		Student student=modelMapper.map(studentDto, Student.class);
		Student insertedStudent =studentRepository.save(student);
		//StudentDto mapToDto=mapToDto(insertedStudent);
		return modelMapper.map(insertedStudent, StudentDto.class);
		//return mapToDto;
		
		/*
		 * StudentDto dto=new StudentDto();
		 * dto.setStudentId(insertedStudent.getStudentId());
		 * dto.setStudentName(insertedStudent.getStudentName());
		 * dto.setStudentAge(insertedStudent.getStudentAge()); return dto;
		 */

	}

	@Override
	public void updateStudent(int studentId, StudentDto studentDto) {
		/*
		 * Student student=new Student(); student.setStudentId(student.getStudentId());
		 * student.setStudentName(student.getStudentName());
		 * student.setStudentAge(student.getStudentAge());
		 */
		//Student student=mapToEntity(studentDto);
		Student student=modelMapper.map(studentDto, Student.class);
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}
	/*public StudentDto mapToDto(Student student) {
		StudentDto dto=new StudentDto();
		dto.setStudentId(student.getStudentId());
		dto.setStudentName(student.getStudentName());
		dto.setStudentAge(student.getStudentAge());
		return dto;
	}
	
	
	public Student mapToEntity(StudentDto studentDto) {
		
		Student student=new Student();
		student.setStudentId(student.getStudentId());
		student.setStudentName(student.getStudentName());
		student.setStudentAge(student.getStudentAge());
		return student;
	}*/

}