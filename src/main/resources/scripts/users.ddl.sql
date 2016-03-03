CREATE TABLE users (
    email     VARCHAR(45)  NOT NULL,
    password  VARCHAR(120) NOT NULL,
    enabled   BOOLEAN      NOT NULL DEFAULT 1,
  PRIMARY KEY (email) );
