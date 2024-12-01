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
 * Testing Springboot.
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

  @Autowired
  private StudentRepository studentRepository;

  Student student;
  Module module;

  @BeforeEach
  void beforeEach() {
<<<<<<< HEAD
    module = new Module(null, "Science", false, null);
    module = moduleRepository.save(module);
    
    student = new Student();
    student = studentRepository.save(student);
=======
    student = new Student(1, "Bob", "Bobby", "xBobx", "bob@gmail.com");
    student = studentRepository.save(student);
    module = new Module("CS2800", "Hardware_Engineering", false, null);
    module = moduleRepository.save(module);
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
  }

  @AfterEach
  void afterEach() {
    gradeRepository.deleteAll();
    moduleRepository.deleteAll();
  }

<<<<<<< HEAD

=======
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
  /**
   * Test to see if sending a request to add grade instance will work as intended.
   * 
   * @param params Contains id of the grade andn the score
   * @throws JsonProcessingException
   * @throws Exception
   */
  @Test
  void addGradeTest() throws JsonProcessingException, Exception {
    Map<String, String> params = new HashMap<String, String>();
    params.put("student_id", String.valueOf(student.getId()));
<<<<<<< HEAD
    params.put("module_code", "1");
=======
    params.put("module_code", String.valueOf(module.getCode()));
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
    params.put("score", "5");

    MvcResult action = mockMvc
        .perform(MockMvcRequestBuilders.post("/grades/addGrade")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(params)).accept(MediaType.APPLICATION_JSON))
        .andReturn();
<<<<<<< HEAD

    assertEquals(HttpStatus.OK.value(), action.getResponse().getStatus());

    // Take action's response as a JSON string, then into Grade object.
    Grade grade = objectMapper.readValue(action.getResponse().getContentAsString(), Grade.class);
    // assertEquals(module.getCode(), grade.getModule().getCode());.
    // assertEquals(module.getName(), grade.getModule().getcode());.
    assertEquals(5, grade.getScore());
    assertNotNull(grade.getScore());
=======
    assertEquals(HttpStatus.OK.value(), action.getResponse().getStatus()); // Test 35.

    // Take action's response as a JSON string, then into Grade object
    Grade grade = objectMapper.readValue(action.getResponse().getContentAsString(), Grade.class);
    assertEquals(module.getCode(), grade.getModule().getCode()); // Test 36.
    assertEquals(module.getName(), grade.getModule().getCode()); // Test 37.
    assertEquals(5, grade.getScore()); // Test 38.
    assertNotNull(grade.getScore()); // Test 39.
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb

    gradeRepository.deleteAll();
  }
}