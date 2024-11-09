package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;

/** This is for the student to register. */
@Entity
public class Registration {
  private Module module;

  /**
   * Constructors.
   *
   * @param module The student is registering.
   */
  public Registration(Module module) {
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

  /**
   * Set the module in registration.
   *
   * @param module the module to set.
   */
  public void setModule(Module module) {
    this.module = module;
  }
}