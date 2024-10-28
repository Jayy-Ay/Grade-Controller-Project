package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/** Unit test for simple App. */
public class AppTest {

  Student student;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
  }

  /**
   * Gets the average of all the scores the student has (in a certain module).
   * 
   * @throws NoGradeAvailableException
   */
  @Test
  void computeAverageTest() throws NoGradeAvailableException {
    for (int i = 0; i < 3; i++) {
      student.addGrade(new Grade(null, null, false, i + 1));
    }
    assertNotNull(student.grades.get(0).getScore());
    assertNotNull(student.grades.get(1).getScore());
    assertNotNull(student.grades.get(2).getScore());
    assertNotNull(student.grades.size());
    assertEquals(1, student.grades.get(0).getScore());
    assertEquals(2, student.grades.get(1).getScore());
    assertEquals(3, student.grades.get(2).getScore());
    assertEquals(3, student.grades.size());
    assertEquals(2, student.computeAverage());
  }

  /** Check if you actually add the grade of the student you assigned it to. */
  @Test
  void addGradeTest() throws NoGradeAvailableException {
    student.addGrade(new Grade(null, null, false, 10));
    student.addGrade(new Grade(null, null, false, 99));
    assertNotNull(student.grades.get(0).getScore());
    assertNotNull(student.grades.get(1).getScore());
    assertEquals(10, student.grades.get(0).getScore());
    assertEquals(99, student.grades.get(1).getScore());
  }

  /** Check if you actually get the grade of the student you assigned it to. */
  @Test
  void getGradeTest() throws NoGradeAvailableException {
    Grade grade = new Grade(null, null, false, 10); // Make grade with score "10"
    Module module = new Module(null, null, false, grade); // Put grade inside module
    student.addGrade(grade);
    Grade actualGrade = student.getGrade(module);
    assertNotNull(actualGrade.getScore());
    assertEquals(10, actualGrade.getScore());
  }

  /** Check if you actually get to register of the student to the module. */
  @Test
  void getRegistrationTest() throws NoRegistrationException {
    Module module = new Module(null, "Maths", false, null);
    student.registerModule(module);
    assertEquals(student)
  }

  @Test
  void NoGradeAvailableException() {
    assertThrows(NoGradeAvailableException.class, () -> {
    });
  }

  @Test
  void NoRegistrationException() {
    assertThrows(NoRegistrationException.class, () -> {
    });
  }
}
