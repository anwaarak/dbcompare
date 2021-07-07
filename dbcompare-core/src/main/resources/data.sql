DROP TABLE IF EXISTS SOURCE;
DROP TABLE IF EXISTS TARGET;

CREATE TABLE SOURCE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

CREATE TABLE TARGET (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL
);

INSERT INTO SOURCE (first_name, last_name, career) VALUES
  ('Jeff', 'Bezos', 'AMZN'),
  ('Bill', 'Gates', 'MSFT'),
  ('Elon', 'Musk', 'TSLA');
  
INSERT INTO TARGET (first_name) VALUES
  ('Jeff'),
  ('Bill'),
  ('Elon');