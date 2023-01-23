package Jai.StudentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Jai.Student.DAO.StudentDAO;
import Jai.Student.api.Student;
import Jai.Student.service.StudentService;

@Controller
public class StudentController {
	

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {

		// call the service to get the data
		List<Student> studentList = studentService.loadStudents();

		model.addAttribute("students", studentList);

		return "student-list";

	}

	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student",student);
		return "add-student";
}
	
	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		
		System.out.println(student);
		
		//do a condition check
		if(student.getId()==0) {
			
			studentService.saveStudent(student);
		}
		else {
			studentService.update(student);
		}
		
		//studentService.saveStudent(student);
		
		return "redirect:/showStudent";
	
	}	
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		
	System.out.println("Looking data for the student having id: " + id);
		
	Student theStudent = studentService.getStudent(id);
	System.out.println(theStudent);
	
	//setting student information
	
//	student.setId(theStudent.getId());
//	student.setName(theStudent.getName());
//	student.setMobile(theStudent.getMobile());
//	student.setCountry(theStudent.getCountry());
	
	model.addAttribute("student", theStudent);
	
	
		return "add-student";
}
	
	//deleteStudent
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
	studentService.deleteStudent(id);
	
		return "redirect:/showStudent";
}
	
	
}