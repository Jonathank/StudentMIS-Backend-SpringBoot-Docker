/**
 * 
 */
package jonathan.mis.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jonathan.mis.model.Student;
import jonathan.mis.service.IStudentService;

/**
 * @author JONATHAN
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/student/api")
public class StudentController {

    private final IStudentService service;

    /**
     * @param service
     */
    public StudentController(IStudentService service) {
	this.service = service;
    }
    
    @GetMapping("/list/allStudents")
    public ResponseEntity<List<Student>>getAllStudents(){
	return new ResponseEntity<>(service.getAllStudent(),HttpStatus.FOUND);
    }
    @PostMapping("/add/new")
    public Student addStudent(@RequestBody Student student) {
	return this.service.addStudent(student);
    }
    
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
	return this.service.updateStudent(student, id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
	this.service.deleteStudent(id);
    }
    
    @GetMapping("/byId/{id}")
    public Student getStudentById(@PathVariable Long id) {
	return this.service.getStudentById(id);    }
}
