package uk.ac.rhul.cs2800.model;

import java.util.List;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;

/** This contains all the important information of the student. */
public class Student {
  private long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  private List<Grade> grades;
  private List<Registration> registrations;

  /** Constructors. 
   * @param long id, String firstName, String lastName, String userName, String email, List<Grade> grades 
   */
  public Student(long id, String firstName, String lastName, String userName, String email,
      List<Grade> grades) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.grades = grades;
  }

  /**
   * Take all grade scores of the student and calculate the average.
   * 
   * @return the average score of the student as a float.
   * @exception NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  public float computeAverage() throws NoGradeAvailableException {
    if (grades.size() < 1) {
      throw new NoGradeAvailableException();
    }
    float sum = 0;
    for (Grade grade : grades) {
      sum += grade.getScore();
    }
    return sum / this.grades.size();
  }

  /**
   * Add and save the student's grade.
   * 
   * @param grade the student's grade that they got.
   */
  public void addGrade(Grade grade) {
    grades.add(grade);
  }

  /**
   * @param module the module that the student took.
   * @return the grade for the student.
   * @exception NoGradeAvailableException If no grade is available/grade doesn't exist.
   */
  public Grade getGrade(Module module) throws NoGradeAvailableException {
    return module.getGrade();
  }

  /**
   * @param module the module that the student is taking.
   */
  public void registerModule(Module module) {
    Registration registration = new Registration(0, null, null, null, null, 0);

  }

  // --------------------------------------------------------------------
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

  /**
   * @return the grades
   */
  public List<Grade> getGrades() {
    return grades;
  }

  /**
   * @param grades the grades to set
   */
  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }

}