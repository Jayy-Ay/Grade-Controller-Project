package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Grade;

public interface gradeRepository extends CrudRepository<Grade, Long> {

}
