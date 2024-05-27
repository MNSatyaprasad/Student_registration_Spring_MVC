package com.beas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beas.model.Student;
import com.beas.service.IStudentMgmtService;

@Controller
public class StudentController {
	@Autowired
	private IStudentMgmtService service;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/std_report")
	public String showAllStudens(Map<String, Object> map) {
		List<Student> list = service.getAllStudent();
		map.put("stdList", list);
		return "show_students_data";
	}
	
	@GetMapping("/std_report_page")
	public String showAllStudentsWithPagination( @PageableDefault(page = 0,size = 2) Pageable pageable, 
			Map<String, Object> map) {
		Page<Student> page = service.getStudentsByPagination(pageable);
		map.put("stdList", page);
		return "show_students_page";
	}
	@GetMapping("/std_add")
	public String registarationForm(@ModelAttribute("std") Student std) {
		return "registration_form";

	}

	@PostMapping("/std_add")
	public String formSubmission(@ModelAttribute("std") Student std, RedirectAttributes attr) {
		System.out.println("StudentController.formSubmission()");
		String msg = service.registatStudent(std);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:std_report_page";
	}

	@GetMapping("/std_update")
	public String fetchById(@RequestParam("no") Integer no, @ModelAttribute("std") Student std) {
		System.out.println("StudentController.fetchById()");
		Student s = service.getStudentByid(no);
		BeanUtils.copyProperties(	s, std);
		return "update_std_registration";
	}
	@PostMapping("/std_update")
	public String updateByid(@ModelAttribute("std") Student std,RedirectAttributes attr) {
		
		System.out.println("StudentController.updateByid()");
		String msg=   service.updateStudentByid(std);
		attr.addFlashAttribute("resultMsg",msg);
		return "redirect:std_report_page";
	}
	@GetMapping("/std_delete")
	public  String deleteById(@RequestParam("no") Integer no,RedirectAttributes attr) {
		
		String msg = service.deleteById(no);
		attr.addFlashAttribute("resultMsg",msg);
		
		return "redirect:std_report_page";
		
		
	}
}
