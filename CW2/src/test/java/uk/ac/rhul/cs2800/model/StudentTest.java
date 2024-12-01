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
    module1 = new Module("CS123", "Math", false);
  }

  /**
   * Check if can get average of all the Grade scores the student has.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  @Test
  void computeAverageTest() throws NoGradeAvailableException {
    // Test 1.
    student.addGrade(new Grade(2));
    student.addGrade(new Grade(4));
    assertNotNull(student.grades.get(0).getScore());
    assertNotNull(student.grades.get(1).getScore());
    assertEquals(2, student.grades.get(0).getScore());
    assertEquals(4, student.grades.get(1).getScore());
    assertEquals(2, student.grades.size());
    assertEquals(3, student.computeAverage());
  }

  /**
   * Check if can register the student to the module.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  @Test
  void getRegistrationTest() throws NoRegistrationException {
    // Test 2.
    student.registerModule(module1);
    assertEquals("Math", module1.getName());
    assertEquals(student.registrations.get(0).getModule().getName(), module1.getName());
  }

  /**
   * Check if can set and get a student's id.
   */
  @Test
  void getIdTest() {
    // Test 3.
    student.setId(0);
    assertNotNull(student.getId());
    assertEquals(0, student.getId());
  }

  /**
   * Check if can set and get a student's first name.
   */
  @Test
  void getFirstNameTest() {
    // Test 4.
    student.setFirstName("Bob");
    assertNotNull(student.getFirstName());
    assertEquals("Bob", student.getFirstName());
  }

  /**
   * Check if can set and get a student's last name.
   */
  @Test
  void getLastNameTest() {
    // Test 5.
    student.setLastName("Bob");
    assertNotNull(student.getLastName());
    assertEquals("Bob", student.getLastName());
  }

  /**
   * Check if can set and get a student's user name.
   */
  @Test
  void getUserNameTest() {
    // Test 6.
    student.setUserName("Bob");
    assertNotNull(student.getUserName());
    assertEquals("Bob", student.getUserName());
  }

  /**
   * Check if can set and get a student's email.
   */
  @Test
  void getEmailTest() {
    // Test 7.
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
  void addGradeTestTest() throws NoGradeAvailableException, NoRegistrationException {
    // Test 8.
    student.addGrade(new Grade(10));
    student.addGrade(new Grade(99));
    assertNotNull(student.grades.get(0).getScore());
    assertNotNull(student.grades.get(1).getScore());
    assertEquals(10, student.grades.get(0).getScore());
    assertEquals(99, student.grades.get(1).getScore());
  }

  /**
   * Check if you actually get the grade of the student you assigned it to. Also tests for
   * unregistered module.
   *
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   * @throws NoRegistrationException If a user try to access grades for unregistered modules.
   */
  @Test
  void getGradeTest() throws NoGradeAvailableException, NoRegistrationException {
    // Test 9.
    Grade grade1 = new Grade(10);
    Grade grade2 = new Grade(5);
    Module module1 = new Module(null, "module1", false);
    Module module2 = new Module(null, "module2", false);
    student.registerModule(module1);
    student.registerModule(module2);
    module1.setGrade(grade1);
    module2.setGrade(grade2);
    assertNotNull(student.registrations); // Test 14
    assertNotNull(student.registrations.get(0).getModule()); // Test 15
    assertEquals("module1", student.registrations.get(0).getModule().getName()); // Test 16
    assertEquals("module2", student.registrations.get(1).getModule().getName()); // Test 17
    assertEquals(10, student.getGrade(module1).getScore()); // Test 18
    assertEquals(5, student.getGrade(module2).getScore()); // Test 19
  }
}