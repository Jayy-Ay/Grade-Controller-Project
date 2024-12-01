package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

<<<<<<< HEAD
/** This is where the grade of a student in a module is stored alongsided their scores. */
=======
/**
 * This is where the grade of a student in a module is stored alongsided their scores.
 */
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
@Entity
public class Grade {
  @Id
  @GeneratedValue
  Long id;

<<<<<<< HEAD
=======
  Integer score; // 'int' not used because 'Integer' allows null value.

>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
  @ManyToOne
  @JoinColumn(name = "student_id")
  Student student;

  @OneToOne
  @JoinColumn(name = "module_code")
  Module module;
<<<<<<< HEAD

  Integer score; // 'int' not used because 'Integer' allows null value.
=======
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb

  /**
   * Constructors.
   *
   * @param score The score of the grade.
   */
  public Grade(Integer score) {
<<<<<<< HEAD
=======
    this.score = score;
  }

  /**
   * Empty Method for GradeCrontroller.
   */
  public Grade() {}

  /**
   * Set the score for this grade.
   *
   * @param score the integer score to set.
   */
  public void setScore(Integer score) {
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
    this.score = score;
  }

  /**
   * Empty Contructor for Springboot.
   */
  public Grade() {
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
   * Set the module for this grade.
   *
   * @param module relating to the grade to set.
   */
<<<<<<< HEAD
  public void setScore(Integer score) {
    this.score = score;
=======
  public void setModule(Module module) {
    this.module = module;
  }

  /**
   * Get the module for this grade.
   *
   * @return module relating to the grade to set.
   */
  public Module getModule() {
    return this.module;
  }

  /**
   * Set the student for this grade.
   *
   * @param student relating to the student to set.
   */
  public void setStudent(Student student) {
    this.student = student;
  }

  /**
   * Get the student for this grade.
   *
   * @return the student's grade.
   */
  public Student getStudent() {
    return this.student;
>>>>>>> 726c14d0061fc3ae2d927d09a1c79ec4700b3dfb
  }

  /**
   * Set the module for this grade.
   *
   * @param module relating to the grade to set.
   */
  public void setModule(Module module) {
    this.module = module;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}