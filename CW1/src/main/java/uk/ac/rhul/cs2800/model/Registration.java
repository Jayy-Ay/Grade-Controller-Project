package uk.ac.rhul.cs2800.model;

/** This is for the student to register. */
public class Registration extends Student {
  private Module module;

  /** Constructors. 
   * @param module */
  public Registration(long id, String firstName, String lastName, String userName, String email,
      Module module) {
    super(id, firstName, lastName, userName, email);
    this.module = module;
  }

  /**
   * @return the module
   */
  public Module getModule() {
    return module;
  }

  /**
   * @param module the module to set
   */
  public void setModule(Module module) {
    this.module = module;
  }
}