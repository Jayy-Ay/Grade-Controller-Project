package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;


/**
 * Testing the student class.
 */
public class StudentTest {
  Student student;
  Module module1;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
    module1 = new Module(null, "Math", false, null);
  }

  /**
   * Check if can get average of all the Grade scores the student has.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  @Test
  void computeAverageTest() throws NoGradeAvailableException {
    student.addGrade(new Grade(2));
    student.addGrade(new Grade(4));
    assertNotNull(student.grades.get(0).getScore()); // Test 1.
    assertNotNull(student.grades.get(1).getScore()); // Test 2.
    assertEquals(2, student.grades.get(0).getScore()); // Test 5.
    assertEquals(4, student.grades.get(1).getScore()); // Test 6.
    assertEquals(2, student.grades.size()); // Test 8.
    assertEquals(3, student.computeAverage()); // Test 9.
  }

  /**
   * Check if can register the student to the module.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  @Test
  void getRegistrationTest() throws NoRegistrationException {
    student.registerModule(module1);
    assertEquals("Math", module1.getName()); // Test 20
    assertEquals(student.registrations.get(0).getModule().getName(), module1.getName()); // Test 21.
  }

  /**
   * Check if can set and get a student's id.
   */
  @Test
  void getId() {
    student.setId(0);
    assertNotNull(student.getId());
    assertEquals(0, student.getId());
  }

  /**
   * Check if can set and get a student's first name.
   */
  @Test
  void getFirstName() {
    student.setFirstName("Bob");
    assertNotNull(student.getFirstName());
    assertEquals("Bob", student.getFirstName());
  }

  /**
   * Check if can set and get a student's last name.
   */
  @Test
  void getLasttName() {
    student.setLastName("Bob");
    assertNotNull(student.getLastName());
    assertEquals("Bob", student.getLastName());
  }

  /**
   * Check if can set and get a student's user name.
   */
  @Test
  void getUserName() {
    student.setUserName("Bob");
    assertNotNull(student.getUserName());
    assertEquals("Bob", student.getUserName());
  }

  /**
   * Check if can set and get a student's email.
   */
  @Test
  void getEmail() {
    student.setEmail("Bob@gmail.com");
    assertNotNull(student.getEmail());
    assertEquals("Bob@gmail.com", student.getEmail());
  }

  /**
   * Check if can set and get a student's module.
   *
   * @throws NoGradeAvailableException.
   */
  @Test
  void addGradeTest() throws NoGradeAvailableException {
    student.addGrade(new Grade(10));
    student.addGrade(new Grade(99));
    assertNotNull(student.grades.get(0).getScore()); // Test 10.
    assertNotNull(student.grades.get(1).getScore()); // Test 11.
    assertEquals(10, student.grades.get(0).getScore()); // Test 12.
    assertEquals(99, student.grades.get(1).getScore()); // Test 13.
  }

  /**
   * Check if can get the grade of the student you assigned it to.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   * @throws NoRegistrationException If a user try to access grades for unregistered modules.
   */
  @Test
  void getGradeTest() throws NoGradeAvailableException, NoRegistrationException {
    Module module2 = new Module(null, "module2", false, null);
    student.registerModule(module1);
    student.registerModule(module2);
    assertNotNull(student.registrations); // Test 14.
    assertNotNull(student.registrations.get(0).getModule()); // Test 15.
    assertEquals("Math", student.registrations.get(0).getModule().getName()); // Test 16.
    assertEquals("module2", student.registrations.get(1).getModule().getName()); // Test 17.
  }
}