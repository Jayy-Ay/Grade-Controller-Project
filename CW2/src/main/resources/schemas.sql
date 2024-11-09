DROP TABLE student IF EXISTS
DROP TABLE grade IF EXISTS
DROP TABLE module IF EXISTS
DROP TABLE registration IF EXISTS

CREATE TABLE student(
  id SERIAL PRIMARY KEY,
  firstName VARCHAR(200),
  lastName VARCHAR(200),
  userName VARCHAR(200),
  email VARCHAR(200)
  );

CREATE TABLE grade(
  id SERIAL PRIMARY KEY,
  student VARCHAR(200),
  score INT,
  FOREIGN KEY (id)
    REFERENCES student (id)
    );

CREATE TABLE module(
  code VARCHAR(200),
  name VARCHAR(200),
  mandatoryNonCondonable VARCHAR(200)
  );

CREATE TABLE registration(
  id SERIAL PRIMARY KEY,
  student VARCHAR(200),
  FOREIGN KEY (id)
    REFERENCES student (id)
    );