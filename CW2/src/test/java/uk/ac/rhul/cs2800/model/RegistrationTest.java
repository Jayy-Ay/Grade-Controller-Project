package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the registration class.
 */
public class RegistrationTest {
  Student student;
  Module module;
  Registration registration;

  @BeforeEach
  void beforeEach() {
    student = new Student(0, null, null, null, null);
    module = new Module("CS2500", null, false);
    registration = new Registration();
  }

  /**
   * Check if can set and get a registration's Id.
   */
  @Test
  void getId() {
    // Test 1.
    registration.setId(Long.valueOf(1));
    assertNotNull(registration.getId());
    assertEquals(1, registration.getId());
  }

  /**
   * Check if can set and get a registration's module.
   */
  @Test
  void getModuleTest() {
    // Test 2.
    registration.setModule(module);
    assertNotNull(registration.getModule());
    assertEquals("CS2500", registration.getModule().getCode());
  }

  /**
   * Check if can set and get a registration's student.
   */
  @Test
  void getStudentTest() {
    // Test 3.
    registration.setStudent(student);
    assertNotNull(registration.getStudent());
    assertEquals(0, registration.getStudent().getId());
  }
}