package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Student;

<<<<<<< HEAD
/** The repository storing all the grade instances. */
public interface StudentRepository extends CrudRepository<Student, Long> {

=======
/**
 * The repository storing all the student instances.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
}