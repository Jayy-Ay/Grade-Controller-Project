package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/** Unit tests. Testing methods and exceptions. */
public class AppTest {

  Student student;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
  }

  /**
   * Gets the average of all the Grade scores the student has (in a certain module).
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  @Test
  void computeAverageTest() throws NoGradeAvailableException {
    for (int i = 0; i < 3; i++) {
      student.addGrade(new Grade(i + 1));
    }
    assertNotNull(student.grades.get(0).getScore()); // Test 1
    assertNotNull(student.grades.get(1).getScore()); // Test 2
    assertNotNull(student.grades.get(2).getScore()); // Test 3
    assertNotNull(student.grades.size()); // Test 4
    assertEquals(1, student.grades.get(0).getScore()); // Test 5
    assertEquals(2, student.grades.get(1).getScore()); // Test 6
    assertEquals(3, student.grades.get(2).getScore()); // Test 7
    assertEquals(3, student.grades.size()); // Test 8
    assertEquals(2, student.computeAverage()); // Test 9
  }

  /**
   * Check if grades are actually added.
   *
   * @throws NoGradeAvailableException.
   */
  @Test
  void addGradeTest() throws NoGradeAvailableException {
    student.addGrade(new Grade(10));
    student.addGrade(new Grade(99));
    assertNotNull(student.grades.get(0).getScore()); // Test 10
    assertNotNull(student.grades.get(1).getScore()); // Test 11
    assertEquals(10, student.grades.get(0).getScore()); // Test 12
    assertEquals(99, student.grades.get(1).getScore()); // Test 13
  }

  /**
   * Check if you actually get the grade of the student you assigned it to.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   * @throws NoRegistrationException If a user try to access grades for unregistered modules.
   */
  @Test
  void getGradeTest() throws NoGradeAvailableException, NoRegistrationException {
    Grade grade1 = new Grade(10);
    Grade grade2 = new Grade(5);
    Module module1 = new Module(null, "module1", false, grade1);
    Module module2 = new Module(null, "module2", false, grade2);
    student.registerModule(module1);
    student.registerModule(module2);
    assertNotNull(student.registrations); // Test 14
    assertNotNull(student.registrations.get(0).getModule()); // Test 15
    assertEquals("module1", student.registrations.get(0).getModule().getName()); // Test 16
    assertEquals("module2", student.registrations.get(1).getModule().getName()); // Test 17
    assertEquals(10, student.getGrade(module1).getScore()); // Test 18
    assertEquals(5, student.getGrade(module2).getScore()); // Test 19
  }

  /**
   * Check if you actually get to register the student to the module. TODO Make the Test Work Then
   * Work On Method.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  @Test
  void getRegistrationTest() throws NoRegistrationException {
    Module module = new Module(null, "Maths", false, null);
    student.registerModule(module);
    assertEquals("Maths", module.getName()); // Test 20
    assertEquals(student.registrations.get(0).getModule().getName(), module.getName()); // Test 21
  }

  /**
   * Check if the exception is working as intended. Relates to: If no grade is available/grade
   * doesn't exist.
   */
  @Test
  void NoGradeAvailableException() {
    assertThrows(NoGradeAvailableException.class, () -> { // Test 22
      student.computeAverage();
    });
    assertThrows(NoGradeAvailableException.class, () -> { // Test 23
      Module module = new Module(null, null, false, null);
      student.registerModule(module);
      student.getGrade(module);
    });
  }

  /**
   * Check if the exception is working as intended. Relates to: If a user try to access grades for
   * unregistered modules.
   */
  @Test
  void NoRegistrationException() {
    assertThrows(NoRegistrationException.class, () -> { // Test 24
      Module module = new Module(null, "Party", false, null);
      student.getGrade(module);
    });
    assertThrows(NoRegistrationException.class, () -> { // Test 25
      Module module1 = new Module(null, "module1", false, null);
      Module module2 = new Module(null, "module2", false, null);
      student.registerModule(module1);
      student.getGrade(module2);
    });
  }

  /**
   * Check if you can set and get a score for the grade
   */
  @Test
  void gradeScoreTest() {
    Grade grade = new Grade(0);
    grade.setScore(5);
    assertEquals(5, grade.getScore()); // Test 26
  }

  /**
   * Check if you can set and get a module for a registration
   */
  @Test
  void registrationModuleTest() {
    Registration registration = new Registration(null);
    Module module = new Module(null, "module", false, null);
    registration.setModule(module);
    assertEquals("module", registration.getModule().getName()); // Test 27
    assertEquals(module.getName(), registration.getModule().getName()); // Test 28
  }
}
