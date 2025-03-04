/**
 * 
 */
package jonathan.mis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jonathan.mis.exception.StudentAlreadyExistException;
import jonathan.mis.exception.StudentNotFoundException;
import jonathan.mis.model.Student;
import jonathan.mis.repository.StudentRepository;

/**
 * 
 */
@Service
public class StudentService implements IStudentService{

    private final StudentRepository repo;
    
    
    /**
     * @param repo
     */
    public StudentService(StudentRepository repo) {
	this.repo = repo;
    }

    @Override
    public Student addStudent(Student student) {
	if(studentAlreadyExist(student.getEmail())) {
	    throw new StudentAlreadyExistException(student.getEmail() +"alreday exists!");
	}
	
	return repo.save(student);
    }


    @Override
    public List<Student> getAllStudent() {
	return repo.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
	
	return repo.findById(id)
		.map(std -> {
		    std.setFirstName(student.getFirstName());
		    std.setLastName(student.getLastName());
		    std.setEmail(student.getEmail());
		    std.setDepartment(student.getDepartment());
		    
		    return repo.save(std);
		}).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
	return repo.findById(id)
		.orElseThrow(() -> new StudentNotFoundException("Sorry, student with id : "+id+" not found"));
    }

    @Override
    public void deleteStudent(Long id) {
	if(!repo.existsById(id)) {
	    throw new StudentNotFoundException("Sorry, student with id : "+id+" not found");
	}
	repo.deleteById(id);
    }
    
    /**
     * @return
     */
    private boolean studentAlreadyExist(String email) {
	return repo.findByEmail(email).isPresent();
    }

}
