package com.beas.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beas.model.Student;

public interface IStudentMgmtService {
	
	public List<Student> getAllStudent();
	
	public String registatStudent(Student std);
	
	public Student getStudentByid(int no);
	
	public String updateStudentByid(Student std);
	
	public String deleteById(int no);

	public Page<Student> getStudentsByPagination(Pageable pageable);
}
