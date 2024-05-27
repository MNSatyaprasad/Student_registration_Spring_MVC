package com.beas.model;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Student_reg")
@Data
@SQLDelete(sql = "update student_reg set status ='inactive' where id =?")
@SQLRestriction("status <> 'inactive'")
public class Student {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "std_seq_id",initialValue = 1999,allocationSize = 10)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String email;
	private Long phoneNumber;
	private LocalDate dob;
	private Long adharNumber;
	private String status="active";
}
