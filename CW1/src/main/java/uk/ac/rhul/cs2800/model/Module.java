package uk.ac.rhul.cs2800.model;

// This is a module that would contain the grade of the student.
public class Module {
  private String code;
  private String name;
  private boolean mnc; // mandatory non-condonable.
  private Grade grade;

  // Constructors.
  public Module(String code, String name, boolean mnc, Grade grade) {
    code = code;
    name = name;
    mnc = mnc;
    grade = grade;
  }

  /**
   * @param grade the student's grade in the module.
   * @return the grade.
   */
  public Grade getGrade() {
    return grade;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the mnc
   */
  public boolean isMnc() {
    return mnc;
  }

  /**
   * @param mnc the mnc to set
   */
  public void setMnc(boolean mnc) {
    this.mnc = mnc;
  }
}