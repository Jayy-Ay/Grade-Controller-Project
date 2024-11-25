package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// This is a module that would contain the grade of the student.
@Entity
public class Module {

  @Id
  String code;

  String name;

  boolean mnc; // ie. mandatory non codonable.

  @OneToOne
  Grade grade;

  /**
   * Constructors.
   *
   * @param code The code for the module.
   * @param name The name of the module.
   * @param mandatoryNonCondonable Also known as mnc.
   * @param grade The gradefor the module.
   */
  public Module(String code, String name, boolean mnc, Grade grade) {
    this.code = code;
    this.name = name;
    this.mnc = mnc;
    this.grade = grade;
  }

  // Empty Method for GradeCrontroller.
  public Module() {}

  /**
   * Get the grade of the student in this particular module.
   *
   * @return this grade.
   */
  public Grade getGrade() {
    return grade;
  }

  /**
   * Get the student's name for this particular module.
   *
   * @return the name as a string
   */
  public String getName() {
    return this.name;
  }
}