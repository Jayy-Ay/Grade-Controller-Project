package uk.ac.rhul.cs2800.model;

import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;

/** This contains all the important information of the student. */
public class Student {
  private long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;

  /** Constructors. */
  public Student(long id, String firstName, String lastName, String userName, String email) {
    id = id;
    firstName = firstName;
    lastName = lastName;
    userName = userName;
    email = email;
  }

  /**
   * @return the average score of the student
   */
  public float computeAverage() {
    float sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return sum / this.scores.size();
  }

  /**
   * @param grade the student's grade that they got.
   * @param score the student's score for that particular grade.
   * @exception NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  public void addGrade(Grade grade, int score) throws NoGradeAvailableException {
    grade.setScore(score);
  }

  /**
   * @param module the module that the student took.
   * @return the grade for the student.
   */
  public Grade getGrade(Module module) {
    return module.getGrade();
  }

  /**
   * @param module the module that the student is taking.
   */
  public void registerModule(Module module) {
    return;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

}