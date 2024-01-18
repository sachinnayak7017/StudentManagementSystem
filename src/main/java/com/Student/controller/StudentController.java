package com.Student.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Student.entity.Students;
import com.Student.repository.StudentRepo;
import com.Student.service.StudentService;
import com.Student.service.SessionHelperStudent;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StudentService Studentservice;
	@Autowired
	private StudentRepo Studentrepo;
	
	@GetMapping("/")
	public String index(Model m) {
		List<Students> Student = Studentservice.getAllStudent();
		m.addAttribute("Student", Student);
		
		return "index";
	}
	
	@GetMapping("/add_student")
	public String addemp() {
		return "add_student";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Students students, HttpSession session) {
		         int hindi = students.getHindi();
		         int english = students.getEnglish();
		         int math = students.getMath();
		         int physics = students.getPhysics();
		         int chamistry = students.getChamistry();
		         float percentags = ((hindi+english+math+physics+chamistry)*100)/500;
                 students.setPercentag(percentags);
                 if(percentags >= 90 && percentags <= 100) {
                	 students.setGrade("A1");
                 }
                 else if(percentags >= 80 && percentags <= 89) {
                	 students.setGrade("A2");
                 }
                 else if(percentags >= 70 && percentags <= 79) {
                	 students.setGrade("B1");
                 }
                 else  if(percentags >= 60 && percentags <= 69) {
                	 students.setGrade("B2");
                 }
                 else if(percentags >= 50 && percentags <= 59) {
                	 students.setGrade("C1");
                 }
                 else if(percentags >= 40 && percentags <= 49) {
                	 students.setGrade("C2");
                 }
                 else if(percentags >= 33 && percentags <= 39) {
                	 students.setGrade("P");
                 }
                 else {
                	 students.setGrade("F");
                 }
//                 System.out.println(students);
                 session.setAttribute("msg", "Student Added Sucessfully..");
               Studentservice.addStudent(students);
		   
               return "redirect:/";
		    }
	
	@GetMapping("/editStudent/{id}")
	public String edit(@PathVariable int id, Model m) {

		Students student = Studentservice.getStudentById(id);

		m.addAttribute("student", student);
		return "editStudent";
	}

	@PostMapping("/update/{id}")
	public String updateEmp(@ModelAttribute Students students, HttpSession session) {
		 int hindi = students.getHindi();
         int english = students.getEnglish();
         int math = students.getMath();
         int physics = students.getPhysics();
         int chamistry = students.getChamistry();
         float percentags = ((hindi+english+math+physics+chamistry)*100)/500;
         students.setPercentag(percentags);
         if(percentags >= 90 && percentags <= 100) {
        	 students.setGrade("A1");
         }
         else if(percentags >= 80 && percentags <= 89) {
        	 students.setGrade("A2");
         }
         else if(percentags >= 70 && percentags <= 79) {
        	 students.setGrade("B1");
         }
         else  if(percentags >= 60 && percentags <= 69) {
        	 students.setGrade("B2");
         }
         else if(percentags >= 50 && percentags <= 59) {
        	 students.setGrade("C1");
         }
         else if(percentags >= 40 && percentags <= 49) {
        	 students.setGrade("C2");
         }
         else if(percentags >= 33 && percentags <= 39) {
        	 students.setGrade("P");
         }
         else {
        	 students.setGrade("F");
         }
         session.setAttribute("msg", "Student Update Sucessfully..");
//         System.out.println(students);
       Studentservice.addStudent(students);
   

			
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		Studentservice.deleteStudent(id);
		session.setAttribute("msg", "Student data delete sucessfully ...");
		return "redirect:/";
	}

}
