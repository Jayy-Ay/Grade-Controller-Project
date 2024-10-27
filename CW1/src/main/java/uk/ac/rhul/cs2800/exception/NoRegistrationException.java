package uk.ac.rhul.cs2800.exception;

import uk.ac.rhul.cs2800.model.Student;

public class NoRegistrationException extends Student {

  // Constructors
  public NoRegistrationException(long id, String firstName, String lastName, String userName,
      String email) {
    super(id, firstName, lastName, userName, email);
  }


}
