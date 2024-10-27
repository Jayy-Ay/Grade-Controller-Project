package uk.ac.rhul.cs2800.model;

public class Module {
  private String code;
  private String name;
  private boolean mnc; // mandatory non-condonable
  private Grade grade;

  // Constructors
  public Module(String code, String name, boolean mnc, Grade grade) {
    code = code;
    name = name;
    mnc = mnc;
    grade = grade;
  }

  /**
   * @return the grade.
   */
  public int getScore() {
    return score;
  }
}