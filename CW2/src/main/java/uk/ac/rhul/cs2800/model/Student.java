package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

<<<<<<< HEAD
/** This contains all the important information of the student. */
@Entity
public class Student {
  @Id
  Long id;

  String firstName;

  String lastName;

  String userName;

  String email;

  @OneToMany(mappedBy = "student") // TODO add mappedBy to other variables if necessary
=======
/**
 * This contains all the important information of the student.
 */
@Entity
public class Student {
  @Id
  Integer id;

  private String firstName;
  private String lastName;
  private String userName;
  private String email;

  @OneToMany(mappedBy = "student")
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
  List<Grade> grades;

  @OneToMany(mappedBy = "student")
  List<Registration> registrations;

  /**
   * Constructors.
   *
   * @param id primary key of student.
   * @param firstName first half of the student's name.
   * @param lastName last half of the student's name.
   * @param userName identifying username.
   * @param email the student's email.
   */
  public Student(Integer id, String firstName, String lastName, String userName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.grades = new ArrayList<Grade>();
    this.registrations = new ArrayList<Registration>();
  }

  /**
   * Empty Contructor for Springboot.
   */
  public Student() {
  }

  /**
   * Take all grade scores of the student and calculate the average.
   *
   * @return the average score of the student as a float.
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
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
   * Add and save the student's grade into a list of grades.
   *
   * @param grade The student's grade that they got.
   */
  public void addGrade(Grade grade) {
    grades.add(grade);
  }

  /**
   * Get the grade of the student via. the module.
   *
   * @param module The module that the student took.
   * @return the grade for the student.
   * @throws NoGradeAvailableException If no grade is available/grade doesn't exist.
   * @throws NoRegistrationException If a user try to access grades for unregistered modules.
   */
  public Grade getGrade(Module module) throws NoGradeAvailableException, NoRegistrationException {
    for (Registration registration : registrations) {
      if (module.getName() == registration.getModule().getName()) {
        if (module.getGrade() != null) {
          return module.getGrade();
        } else {
          throw new NoGradeAvailableException();
        }
      } else {
        continue;
      }
    }
    throw new NoRegistrationException();
  }

  /**
   * Register the student with the module.
   *
   * @param module The module that the student is taking.
   * @throws NoRegistrationException If a user try to access grades for unregistered modules.
   */
  public void registerModule(Module module) throws NoRegistrationException {
    Registration registation = new Registration(module);
    registrations.add(registation);
  }

  /**
<<<<<<< HEAD
   * Returns the id of the student.
   *
   * @return id the student id
   */
  public Long getId() {
    return this.id;
  }
=======
   * Set the studendt's id.
   *
   * @param id The student's id.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Get the studendt's id.
   *
   * @return the student's id.
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Set the student's first name.
   *
   * @param firstName the student's firstName.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  /**
   * Get the studendt's first name.
   *
   * @return the student's firstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the last name of the student.
   *
   * @param lastName The student's last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Return the last name of the student.
   *
   * @return the student's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the user name of the student.
   *
   * @param userName The student's user name.
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Return the user name of the student.
   *
   * @return the student's user name.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Set the email of the student.
   *
   * @param email The student's email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Return the email of the student.
   *
   * @return the student's email.
   */
  public String getEmail() {
    return email;
  }
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
}