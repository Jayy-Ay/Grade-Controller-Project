package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 * This is for the student to register.
 */
@Entity
public class Registration {
  @Id
  @GeneratedValue
  Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  Student student;

  @OneToOne
  @JoinColumn(name = "module_code")
  Module module;

  /**
   * Constructors.
   *
   * @param module The student is registering.
   */
  public Registration(Module module) {
    this.module = module;
  }

  /**
   * Empty Method for GradeCrontroller.
   */
  public Registration() {}

  /**
   * Set id for registration.
   *
   * @param id The id for registration.
   */
  public void setId(Long id) {
    this.id = id;
  }


  /**
   * Get id for registration.
   *
   * @return The id for registration.
   */
  public Long getId() {
    return id;
  }

  /**
   * Set student for registration.
   *
   * @param student The student for registration.
   */
  public void setStudent(Student student) {
    this.student = student;
  }

  /**
   * Get student for registration.
   *
   * @return The student for registration.
   */
  public Student getStudent() {
    return student;
  }

  /**
   * Set the module in registration.
   *
   * @param module the module to set.
   */
  public void setModule(Module module) {
    this.module = module;
  }

  /**
   * Get the module and retunr the module.
   *
   * @return the module.
   */
  public Module getModule() {
    return module;
  }
}