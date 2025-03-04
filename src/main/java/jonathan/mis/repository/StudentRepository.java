/**
 * 
 */
package jonathan.mis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jonathan.mis.model.Student;

/**
 * @author JONATHAN
 */
public interface StudentRepository extends JpaRepository<Student,Long>{

    /**
     * @param email
     * @return
     */
    Optional<Student>findByEmail(String email);

}
