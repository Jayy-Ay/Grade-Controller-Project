package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class Grade {
  @Id
  Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  Student student;

  @OneToOne
  @JoinColumn(name = "module_code")
  Module module;

  Integer score; // 'int' not used because 'Integer' allows null value.

  /**
   * Constructors.
   *
   * @param score The score of the grade.
   */
  public Grade(Integer score) {
    this.score = score;
  }

  /**
   * Get the score of this grade.
   *
   * @return the score as in integer.
   */
  public Integer getScore() {
    return score;
  }

  /**
   * Set the score for this grade.
   *
   * @param score the integer score to set.
   */
  public void setScore(Integer score) {
    this.score = score;
  }

  /**
   * Set the module for this grade.
   *
   * @param module relating to the grade to set.
   */
  public void setModule(Module module) {
    this.module = module;
  }
}