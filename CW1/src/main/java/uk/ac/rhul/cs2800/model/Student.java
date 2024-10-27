package uk.ac.rhul.cs2800.model;

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
    float sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return sum / this.scores.size();
  }

  public void addGrade(Grade grade, int score) {
    grade.setScore(score);
  }

  public Grade getGrade(Module module) {
    return module.getScore();
  }

  public void registerModule() {
    return;
  }

}