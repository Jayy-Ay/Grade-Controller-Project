package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * Grade controller manages grade instances.
 */
@RestController
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
  @PostMapping(value = "/grades/addGrade")
  public ResponseEntity<Grade> addGrade(@RequestBody Map<String, String> params) {
    // Find the student by using student_id.
    Student student =
        studentRepository.findById(Long.valueOf(params.get("student_id")))
            .orElseThrow(() -> new IllegalArgumentException("Student not found"));

    // Find the module by using the module_code.
    Module module =
        moduleRepository.findById(String.valueOf(params.get("module_code")))
            .orElseThrow(() -> new IllegalArgumentException("Module not found"));

    // Create a Grade object and set all values.
    Grade grade = new Grade(0);
    grade.setScore(Integer.valueOf(params.get("score")));
    grade.setModule(module);
    grade.setStudent(student);

    // Save the Grade object.
    grade = gradeRepository.save(grade);
    return ResponseEntity.ok(grade);
  }
}