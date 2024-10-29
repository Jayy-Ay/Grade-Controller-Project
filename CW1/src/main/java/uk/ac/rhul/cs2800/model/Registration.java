package uk.ac.rhul.cs2800.model;

/** This is for the student to register. */
public class Registration extends Student {
  private Module module;

  /**
   * Constructors.
   * 
   * 
   * @param id The primary key of student.
   * @param firstName The first half of the student's name.
   * @param lastName The last half of the student's name.
   * @param userName The identifying username.
   * @param email The student's email.
   * @param module The student is registering.
   * 
   */
  public Registration(long id, String firstName, String lastName, String userName, String email,
      Module module) {
    super(id, firstName, lastName, userName, email);
    this.module = module;
  }

  /**
   * Get the module and retunr the module.
   * 
   * 
   * @return the module.
   * 
   */
  public Module getModule() {
    return module;
  }

  /**
   * Set the module in registration.
   * 
   * 
   * @param module the module to set.
   * 
   */
  public void setModule(Module module) {
    this.module = module;
  }
}