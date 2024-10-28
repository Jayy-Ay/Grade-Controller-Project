package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  /** Gets the average of all the scores the student has (in a certain module). */
  @Test
  void getAverageTest() throws NoGradeAvailableException, NoRegistrationException {
    assertEquals(5.0, student.computeAverage());
  }

  /** Check if you actually get the grade of the student you assigned it to. */
  @Test
  void getGradeTest() throws NoGradeAvailableException {
    Grade grade = new Grade(0, null, null, null, null, 0);
    Module module = new Module(null, null, false, grade);
    student.addGrade(grade, 10);
    Grade actualGrade = student.getGrade(module);
    assertEquals(10, actualGrade.getScore());
  }

  /** Check if you actually get to register of the student to the module. */
  @Test
  void getRegistrationTest() throws NoRegistrationException {
    Module module = new Module(null, null, false, null);
    student.registerModule(module);
  }

}
