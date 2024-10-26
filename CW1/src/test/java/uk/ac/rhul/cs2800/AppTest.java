package uk.ac.rhul.cs2800;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/** Unit test for simple App. */
public class AppTest {

  /** Rigorous Test :-) */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /** Check if you actually get the grade of the student you assigned it to*/
    @Test 
    public void getAverageTest() {
      Grade grade = new Grade(0, null, null, null, null, 0);
      grade.addGrade(10);
    }
}
