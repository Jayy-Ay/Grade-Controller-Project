package uk.ac.rhul.cs2800.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;

/**
 * Testing the Exceptions.
 */
public class ExceptionTest {
  Student student;
  Module module;
  Grade grade;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
    module = new Module(null, "Math", false);
    grade = new Grade(100);
  }

  /**
   * Check if the exception works. Related: If no grade is available/grade doesn't exist.
   */
  @Test
  void NoGradeAvailableException() {
    // Test 1.
    assertThrows(NoGradeAvailableException.class, () -> {
      student.computeAverage();
    });
    assertThrows(NoGradeAvailableException.class, () -> {
      Module module = new Module(null, null, false);
      student.registerModule(module);
      student.getGrade(module);
    });
  }

  /**
   * Check if the exception works. Related: If a user try to access grades for unregistered modules.
   */
  @Test
  void NoRegistrationException() {
    // Test 2.
    assertThrows(NoRegistrationException.class, () -> {
      student.getGrade(module);
    });
    assertThrows(NoRegistrationException.class, () -> {
      Module module1 = new Module(null, "module1", false);
      Module module2 = new Module(null, "module2", false);
      student.registerModule(module1);
      student.getGrade(module2);
    });
  }
}