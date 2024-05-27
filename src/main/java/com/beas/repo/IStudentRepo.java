package com.beas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beas.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
