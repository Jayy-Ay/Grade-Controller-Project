package uk.ac.rhul.cs2800.model;

/** This is where the grade of a student in a module is stored alongsided their scores. */
public class Grade extends Module {
  private int score;

  /** Constructors. */
  public Grade(String code, String name, boolean mnc, int score) {
    super(code, name, mnc, null);
    this.score = score;
  }

  /**
   * @return the score.
   */
  public int getScore() {
    return score;
  }

  /**
   * @param score the score to set.
   */
  public void setScore(int score) {
    this.score = score;
  }
}