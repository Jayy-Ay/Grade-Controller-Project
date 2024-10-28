package uk.ac.rhul.cs2800.model;

/** This is where the grade of a student in a module is stored alongsided their scores. */
public class Grade extends Student {
  private int score;

  /** Constructors. */
  public Grade(long id, String firstName, String lastName, String userName, String email,
      int score) {
    super(id, firstName, lastName, userName, email);
    score = score;
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