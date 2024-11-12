package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Registration;

/** The repository storing all the grade instances. */
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
