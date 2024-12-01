package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

<<<<<<< HEAD
/** This is a module that would contain the grade of the student. */
=======
/**
 * This is a school module that would contain grades.
 */
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
@Entity
public class Module {
  @Id
  String code;

<<<<<<< HEAD
  String name;

  boolean mnc; // ie. mandatory non codonable.

  @OneToOne
  Grade grade;
=======
  private String name;

  private boolean mnc; // ie. mandatory non codonable.

  @OneToOne
  Grade grade;

  @OneToOne
  Registration registration;
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb

  /**
   * Constructors.
   *
   * @param code The code for the module.
   * @param name The name of the module.
<<<<<<< HEAD
   * @param mnc Also known as mnc.
=======
   * @param mnc Also known as andatoryNonCondonable
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
   * @param grade The gradefor the module.
   */
  public Module(String code, String name, boolean mnc, Grade grade) {
    this.code = code;
    this.name = name;
    this.mnc = mnc;
    this.grade = grade;
  }

  /**
<<<<<<< HEAD
   * Empty Contructor for Springboot.
   */
  public Module() {
  }

  /**
   * Get the grade of the student in this particular module.
   *
   * @return this grade.
   */
  public Grade getGrade() {
    return grade;
=======
   * Empty Method for GradeCrontroller.
   */
  public Module() {}

  /**
   * Set code for module.
   *
   * @param code The code for module.
   */
  public void setCode(String code) {
    this.code = code;
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
  }

  /**
   * Get code for module.
   *
   * @return The code for module.
   */
  public String getCode() {
    return this.code;
  }

  /**
   * Set name for module.
   *
   * @param name The name for module.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get name for module.
   *
   * @return The name for module.
   */
  public String getName() {
    return this.name;
  }
<<<<<<< HEAD
=======

  /**
   * Set mnc for module.
   *
   * @param mnc The mnc for module.
   */
  public void setMnc(Boolean mnc) {
    this.mnc = mnc;
  }

  /**
   * Get mnc for module.
   *
   * @return The mnc for module.
   */
  public boolean getMnc() {
    return this.mnc;
  }

  /**
   * Set grade for module.
   *
   * @param grade The grade for module.
   */
  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  /**
   * Get grade for module.
   *
   * @return The grade for module.
   */
  public Grade getGrade() {
    return grade;
  }

  /**
   * Set registration for module.
   *
   * @param registration The registration for module.
   */
  public void setRegistration(Registration registration) {
    this.registration = registration;
  }

  /**
   * Get registration for module.
   *
   * @return The registration for module.
   */
  public Registration getRegistration() {
    return registration;
  }
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
}