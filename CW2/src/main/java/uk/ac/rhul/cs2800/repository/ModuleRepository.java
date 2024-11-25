package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Module;

/** The repository storing all the grade instances. */
public interface ModuleRepository extends CrudRepository<Module, Long> {

}