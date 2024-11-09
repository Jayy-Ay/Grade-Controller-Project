package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/** This is where the grade of a student in a module is stored alongsided their scores. */
@Entity
public class Grade {
  private int score;

  @Id
  @GeneratedValue
  Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  Student student;

  /**
   * Constructors.
   *
   * @param score The score of the grade.
   */
  public Grade(int score) {
    this.score = score;
  }

  /**
   * Get the score of this grade.
   *
   * @return the score as in integer.
   */
  public int getScore() {
    return score;
  }

  /**
   * Set the score for this grade.
   *
   * @param score the integer score to set.
   */
  public void setScore(int score) {
    this.score = score;
  }
}