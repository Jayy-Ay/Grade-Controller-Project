package uk.ac.rhul.cs2800.model;

import java.util.List;

/** This is for the student to register. */
public class Registration extends Student {

  /** Constructors. */
  public Registration(long id, String firstName, String lastName, String userName, String email,
      List<Grade> grades) {
    super(id, firstName, lastName, userName, email, grades);
  }
}