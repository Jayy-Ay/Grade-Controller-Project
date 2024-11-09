package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/** This contains all the important information of the student. */
@Entity
public class Student {

  @Id
  @GeneratedValue
  Long id;

  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  List<Grade> grades;
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
  public Student(long id, String firstName, String lastName, String userName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.grades = new ArrayList<Grade>();
    this.registrations = new ArrayList<Registration>();
  }

  /**
   * Take all grade scores of the student and calculate the average.
   *
   * @return the average score of the student as a float.
   *
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
   * Add and save the student's grade into a list of grades.
   *
   * @param grade the student's grade that they got.
   */
  public void addGrade(Grade grade) {
    grades.add(grade);
  }

  /**
   * Get the grade of the student via. the module.
   *
   * @param module the module that the student took.
   *
   * @return the grade for the student.
   * @exception NoGradeAvailableException If no grade is available/grade doesn't exist.
   * @exception NoRegistrationException If a user try to access grades for unregistered modules.
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
   * @param module the module that the student is taking.
   *
   * @exception NoRegistrationException If a user try to access grades for unregistered modules.
   */
  public void registerModule(Module module) throws NoRegistrationException {
    Registration registation =
        new Registration(module);
    registrations.add(registation);
  }
}