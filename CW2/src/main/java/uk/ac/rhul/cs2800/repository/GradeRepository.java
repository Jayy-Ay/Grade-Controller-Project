package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Grade;

/** The repository storing all the grade instances. */
public interface gradeRepository extends CrudRepository<Grade, Long> {

}
