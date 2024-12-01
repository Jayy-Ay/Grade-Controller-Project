package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;

/**
 * Testing the module class.
 */
public class ModuleTest {
  Module module;
  Grade grade;

  @BeforeEach
  void beforeEach() {
    module = new Module();
    grade = new Grade(100);
  }

  /**
   * Check if can set and get a module's code.
   */
  @Test
  void getCode() {
    module.setCode("CS2500");
    assertNotNull(module.getCode());
    assertEquals("CS2500", module.getCode());
  }

  /**
   * Check if can set and get a module's name.
   */
  @Test
  void getName() {
    module.setName("Math");
    assertNotNull(module.getName());
    assertEquals("Math", module.getName());
  }

  /**
   * Check if can set and get a module's mnc.
   */
  @Test
  void getMnc() {
    module.setMnc(true);
    assertNotNull(module.getMnc());
    assertEquals(true, module.getMnc());
  }

  /**
   * Check if can set and get a module's grade.
   *
   * @throws NoGradeAvailableException If no grade is available/grade don't exist.
   */
  @Test
  void getGrade() throws NoGradeAvailableException {
    module.setGrade(grade);
    assertNotNull(module.getGrade());
    assertEquals(100, module.getGrade().getScore());
  }
}