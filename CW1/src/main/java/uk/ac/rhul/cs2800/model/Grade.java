package uk.ac.rhul.cs2800.model;

/** This is where the grade of a student in a module is stored alongsided their scores. */
public class Grade extends Module {
  private int score;

  /**
   * Constructors.
   * 
   * @param code The code for the module.
   * @param name The name of the module.
   * @param mnc Also known as mandatory non-condonable.
   * @param score The score of the grade.
   * 
   */
  public Grade(String code, String name, boolean mnc, int score) {
    super(code, name, mnc, null);
    this.score = score;
  }

  /**
   * Get the score of this grade.
   * 
   * @return the score as in integer.
   * 
   */
  public int getScore() {
    return score;
  }

  /**
   * Set the score for this grade.
   * 
   * @param score the integer score to set.
   * 
   */
  public void setScore(int score) {
    this.score = score;
  }
}