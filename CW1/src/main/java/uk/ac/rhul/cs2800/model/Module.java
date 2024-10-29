package uk.ac.rhul.cs2800.model;

/** This is a module that would contain the grade of the student. */
public class Module extends Registration {
  private String code;
  private String name;
  private boolean mnc; // ie. mandatory non-condonable
  private Grade grade;

  /**
   * Constructors.
   * 
   * @param code code for the module.
   * @param name name of the module.
   * @param mnc mandatory non-condonable.
   * @param grade for the module.
   * 
   */
  public Module(String code, String name, boolean mnc, Grade grade) {
    super(0, null, null, null, null, null);
    this.code = code;
    this.name = name;
    this.mnc = mnc;
    this.grade = grade;
  }

  /**
   * Get the grade of the student in this particular module.
   * 
   * @return this grade.
   * 
   */
  public Grade getGrade() {
    return this.grade;
  }

  /**
   * Set the student's grade for this particular module.
   * 
   * @return the grade.
   * 
   */
  public Grade setGrade() {
    return grade;
  }

  /**
   * Get the student's name for this particular module.
   * 
   * @return the name as a string
   * 
   */
  public String getName() {
    return this.name;
  }
}
