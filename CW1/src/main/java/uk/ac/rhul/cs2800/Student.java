package uk.ac.rhul.cs2800;

public class Student {
  private long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;

  // Constructors
  public Student(long id, String firstName, String lastName, String userName, String email) {
    id = id;
    firstName = firstName;
    lastName = lastName;
    userName = userName;
    email = email;
  }

  public float computeAverage() {
    return 0;
  }

  public void addGrade(Grade grade) {
    grade.setScore(10);
  }

  public Grade getGrade() {
    return null;
  }

  public void registerModule() {
    return;
  }


}