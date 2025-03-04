/**
 * 
 */
package jonathan.mis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jonathan.mis.model.Student;

/**
 * @
 * 
 */
@Service
public interface IStudentService {

    Student addStudent(Student student);
    List<Student>getAllStudent();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}
