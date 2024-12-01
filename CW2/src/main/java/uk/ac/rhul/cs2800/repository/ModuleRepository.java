package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Module;

<<<<<<< HEAD
/** The repository storing all the grade instances. */
public interface ModuleRepository extends CrudRepository<Module, Long> {

=======
/**
 * The repository storing all the module instances.
 */
public interface ModuleRepository extends CrudRepository<Module, String> {
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
}