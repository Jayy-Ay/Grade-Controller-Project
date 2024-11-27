package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * This is a school module that would contain grades.
 */
@Entity
public class Module {
  @Id
  String code;

  private String name;

  private boolean mnc; // ie. mandatory non codonable.

  @OneToOne
  Grade grade;

  @OneToOne
  Registration registration;

  /**
   * Constructors.
   *
   * @param code The code for the module.
   * @param name The name of the module.
   * @param mnc Also known as andatoryNonCondonable
   * @param grade The gradefor the module.
   */
  public Module(String code, String name, boolean mnc, Grade grade) {
    this.code = code;
    this.name = name;
    this.mnc = mnc;
    this.grade = grade;
  }

  /**
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
}