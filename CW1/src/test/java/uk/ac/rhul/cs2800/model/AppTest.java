package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/** Unit test for simple App. */
public class AppTest {

  Student student;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null, null);
  }

  /** Gets the average of all the scores the student has (in a certain module). */
  @Test
  void computeAverageTest() throws NoGradeAvailableException, NoRegistrationException {
    List<Grade> grades = new ArrayList<Grade>();
    for (int i = 0; i < 3; i++) {
      grades.add(new Grade(0, null, null, null, null, i + 1));
    }
    student.computeAverage();

    assertEquals(5.0, student.computeAverage());
  }

  /** Check if you actually add the grade of the student you assigned it to. */
  @Test
  void addGradeTest() throws NoGradeAvailableException {
    Grade grade = new Grade(0, null, null, null, null, 10); // Make grade with score "10"
    student.addGrade(null);

  }


  /** Check if you actually get the grade of the student you assigned it to. */
  @Test
  void getGradeTest() throws NoGradeAvailableException {
    Grade grade = new Grade(0, null, null, null, null, 10); // Make grade with score "10"
    Module module = new Module(null, null, false, grade, null); // Put grade inside module
    student.addGrade(grade);
    Grade actualGrade = student.getGrade(module);
    assertEquals(10, actualGrade.getScore());
  }

  /** Check if you actually get to register of the student to the module. */
  @Test
  void getRegistrationTest() throws NoRegistrationException {
    Module module = new Module(null, null, false, null, null);
    student.registerModule(module);
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
