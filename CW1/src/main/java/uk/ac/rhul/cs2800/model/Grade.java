package uk.ac.rhul.cs2800.model;

/** This is where the grade of a student in a module is stored alongsided their scores. */
public class Grade extends Module {
  private int score;

  /**
   * Constructors.
   * 
   * @param code
   * @param name
   * @param mnc
   * @param score
   */
  public Grade(String code, String name, boolean mnc, int score) {
    super(code, name, mnc, null);
    this.score = score;
  }

  /**
   * @return the score as in integer.
   */
  public int getScore() {
    return score;
  }

  /**
   * @param score the integer score to set.
   */
  public void setScore(int score) {
    this.score = score;
  }
}