package uk.ac.rhul.cs2800.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;

public class ExceptionTest {
  Student student;
  Module module;
  Grade grade;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
    module = new Module(null, "Math", false, null);
    grade = new Grade(100);
  }

  /**
   * Check if the exception works. Related: If no grade is available/grade doesn't exist.
   */
  @Test
  void NoGradeAvailableException() {
    assertThrows(NoGradeAvailableException.class, () -> { // Test 25.
      student.computeAverage();
    });
    assertThrows(NoGradeAvailableException.class, () -> { // Test 26.
      Module module = new Module(null, null, false, null);
      student.registerModule(module);
      student.getGrade(module);
    });
  }

  /**
   * Check if the exception works. Related: If a user try to access grades for unregistered modules.
   */
  @Test
  void NoRegistrationException() {
    assertThrows(NoRegistrationException.class, () -> { // Test 27.
      student.getGrade(module);
    });
    assertThrows(NoRegistrationException.class, () -> { // Test 28.
      Module module1 = new Module(null, "module1", false, null);
      Module module2 = new Module(null, "module2", false, null);
      student.registerModule(module1);
      student.getGrade(module2);
    });
  }
}