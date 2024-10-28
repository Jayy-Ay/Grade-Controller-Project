package uk.ac.rhul.cs2800.model;

/** This is a module that would contain the grade of the student. */
public class Module extends Registration {
  private String code;
  private String name;
  private boolean mnc; // mandatory non-condonable.
  private Grade grade;

  /**
   * Constructors.
   * 
   * @param grade
   */
  public Module(String code, String name, boolean mnc, Grade grade) {
    super(0, null, null, null, null, null);
    this.code = code;
    this.name = name;
    this.mnc = mnc;
    this.grade = grade;
  }

  /**
   * @param grade the student's grade in the module.
   * @return the grade.
   */
  public Grade getGrade() {
    return this.grade;
  }

  /**
   * @param grade the student's grade in the module.
   * @return the grade.
   */
  public Grade setGrade() {
    return grade;
  }
}
