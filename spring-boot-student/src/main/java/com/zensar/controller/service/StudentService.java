package com.zensar.controller.service;



import java.util.List;

import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;

public interface StudentService {
	public StudentDto getStudent(int studentId);

	public List<StudentDto> getStudents(int pageNumber, int pageSize);

	public StudentDto insertStudent(StudentDto studentdto);

	public void deleteStudent(int studentId);

	public StudentDto updateStudent(int studentId, StudentDto studentDto);

	public List<StudentDto> getByStudentName(String studentName);

	public List<StudentDto> getByStudentNameAndStudentAge(String studentName, int age);

	public List<StudentDto> getByStudentNameOrStudentAge(String studentName, int age);

	public List<StudentDto> getByStudentNameEndsWith(String suffix);

	public List<StudentDto> findByStudentNameOrderBy(String studentName);

}