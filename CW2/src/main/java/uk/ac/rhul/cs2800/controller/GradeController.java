
package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.RegistrationRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * Controller.
 */
public class GradeController {

  private final GradeRepository gradeRepository;
  private final RegistrationRepository registrationRepository;
  private final StudentRepository studentRepository;
  private final ModuleRepository moduleRepository;

  public GradeController(GradeRepository gradeRepository, RegistrationRepository registrationRepository, StudentRepository studentRepository, ModuleRepository moduleRepository) {
    this.gradeRepository = gradeRepository;
    this.registrationRepository = registrationRepository;
    this.studentRepository = studentRepository;
    this.moduleRepository = moduleRepository;
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
    // Find the student by using student_id
    Student student =
        studentRepository.findById(Long.valueOf(params.get("student_id"))).orElseThrow();

    // Find the module by using the module_code
    Module module =
        moduleRepository.findById(Long.valueOf(params.get("module_code"))).orElseThrow();

    // Create a Grade object and set all values
    Grade grade = new Grade(0);
    grade.setScore(Integer.valueOf(params.get("score")));
    grade.setModule(module);

    // Save the Grade object.
    gradeRepository.save(grade);

    // Return the saved Grade object.
    return ResponseEntity.ok(grade);
  }
}
