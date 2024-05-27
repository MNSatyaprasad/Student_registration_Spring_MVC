package com.beas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beas.model.Student;
import com.beas.repo.IStudentRepo;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	@Autowired
	private IStudentRepo repo;

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public String registatStudent(Student std) {
		return "Student Saved SucessFully with id ::" + repo.save(std).getId();
	}
	
	@Override
	public Student getStudentByid(int no) {
		return	repo.findById(no).orElseThrow(()-> new IllegalArgumentException("No id is found"));
	}
	@Override
	public String updateStudentByid(Student std) {
		return "Student update Sucessfully with id ::"+repo.save(std).getId();
	}
	@Override
	public String deleteById(int no) {
		repo.deleteById(no);
		return "Deleted Sucessfully with id::  "+no;
	}
	@Override
	public Page<Student> getStudentsByPagination(Pageable pageable) {
		 
		return repo.findAll(pageable);
	}
}
