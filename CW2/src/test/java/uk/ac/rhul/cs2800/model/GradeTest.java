package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the grade class.
 */
public class GradeTest {
  Student student;
  Module module;
  Grade grade;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
    module = new Module("CS2500", "Hardware_Engineering", false, null);
    grade = new Grade(100);
  }

  /**
   * Check if can set and get a score using grade.
   */
  @Test
  void getScoreTest() {
    grade.setScore(5);
    assertNotNull(grade.getScore());
    assertEquals(5, grade.getScore());
  }

  /**
   * Check if can set and get a module using grade.
   */
  @Test
  void getModuleTest() {
    grade.setModule(module);
    grade.getModule();
    assertNotNull(grade.getModule());
    assertEquals("CS2500", grade.getModule().getCode());
  }

  /**
   * Check if can set and get a student using grade.
   */
  @Test
  void getStudent() {
    grade.setStudent(student);
    assertNotNull(grade.getStudent());
    assertEquals(0, grade.getStudent().getId());
  }
}