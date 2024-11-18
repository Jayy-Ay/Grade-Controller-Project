
package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * Grade controller manages grade instances.
 */
@SpringBootApplication
public class GradeController {

  private final GradeRepository gradeRepository;
  private final StudentRepository studentRepository;
  private final ModuleRepository moduleRepository;

  /**
   * Constructors.
   *
   * @param gradeRepository stores all grade instances.
   * @param studentRepository stores all student instances.
   * @param moduleRepository stores all module instances.
   */
  public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository,
      ModuleRepository moduleRepository) {
    this.gradeRepository = gradeRepository;
    this.studentRepository = studentRepository;
    this.moduleRepository = moduleRepository;
  }

  /**
   * Learning Notes: @RestContoller defines API endpoints, @PostMapping sends a POST request to
   * /grades/addGrade. Also has Get/Put/Delete Mapping.
   *
   * @param params should contain student_id, module_code and score.
   * @return saved grade instance.
   */
  @PostMapping(value = "/grade/addGrade")
  public ResponseEntity<Grade> addRate(@RequestBody Map<String, String> params) {
    // Find the student by using student_id.
    Student student =
        studentRepository.findById(Long.valueOf(params.get("student_id"))).orElseThrow();

    // Find the module by using the module_code.
    Module module =
        moduleRepository.findById(Long.valueOf(params.get("module_code"))).orElseThrow();

    // Create a Grade object and set all values.
    Grade grade = new Grade(0);
    grade.setScore(Integer.valueOf(params.get("score")));
    grade.setModule(module);

    // Save the Grade object.
    gradeRepository.save(grade);

    // Return the saved Grade object.
    return ResponseEntity.ok(grade);
  }
}
