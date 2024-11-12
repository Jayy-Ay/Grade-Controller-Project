
package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.RegistrationRepository;

/**
 * Controller.
 */
public class GradeController {

  private final GradeRepository gradeRepository;
  private final RegistrationRepository registrationRepository;

  public GradeController(GradeRepository gradeRepository, RegistrationRepository registrationRepository) {
    this.gradeRepository = gradeRepository;
    this.registrationRepository = registrationRepository;
  }

  /**
   * Learning Notes: @RestContoller defines API endpoints, @PostMapping sends a POST request to
   * /grades/addGrade. Also has Get/Put/Delete Mapping.
   * 
   * @param params the parameter.
   * @return null as in nothing.
   */
  @PostMapping(value="/grade/addGrade")
  public ResponseEntity<Grade> addRate(@RequestBody Map<String, String> params) {
    return null;
    // Find the student by using student_id
    // Find the module by using the module_code
    // Create a Grade object and set all values
    // Save the Grade object.
    // Return the saved Grade object.
  }
}
