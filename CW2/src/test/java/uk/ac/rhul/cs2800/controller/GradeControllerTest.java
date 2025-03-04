package uk.ac.rhul.cs2800.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * Testing the Grade Controller.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class GradeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private ModuleRepository moduleRepository;

  @Autowired
  private GradeRepository gradeRepository;

  Student student;
  Module module;

  @BeforeEach
  void beforeEach() {
    student = new Student(1, "Bob", "Bobby", "xBobx", "bob@gmail.com");
    student = studentRepository.save(student);
    module = new Module("CS2800", "Hardware_Engineering", false);
    module = moduleRepository.save(module);
  }

  @AfterEach
  void afterEach() {
    gradeRepository.deleteAll();
    moduleRepository.deleteAll();
  }

  /**
   * Test to see if sending a request to add grade instance will work as intended.
   * 
   * @param params Contains id of the grade andn the score.
   * @throws JsonProcessingException Error in processing JSON data.
   * @throws Exception If any error occurs.
   */
  @Test
  void addGradeTest() throws JsonProcessingException, Exception {
    // Test 1.
    Map<String, String> params = new HashMap<String, String>();
    params.put("student_id", String.valueOf(student.getId()));
    params.put("module_code", String.valueOf(module.getCode()));
    params.put("score", "5");

    MvcResult action = mockMvc
        .perform(MockMvcRequestBuilders.post("/grades/addGrade")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(params)).accept(MediaType.APPLICATION_JSON))
        .andReturn();

    // Take action's response as a JSON string, then into Grade object
    Grade grade = objectMapper.readValue(action.getResponse().getContentAsString(), Grade.class);
    assertEquals(module.getCode(), grade.getModule().getCode());
    assertEquals(module.getName(), grade.getModule().getName());
    assertEquals(5, grade.getScore());
    assertNotNull(grade.getScore());
    assertEquals(HttpStatus.OK.value(), action.getResponse().getStatus());
    assertEquals(String.valueOf(student.getId()), params.get("student_id"));
    assertEquals(String.valueOf(student.getId()), params.get("module_code"));

    gradeRepository.deleteAll();
  }
}