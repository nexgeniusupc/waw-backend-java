CREATE TABLE users
(
  id             BIGINT AUTO_INCREMENT NOT NULL,
  created_at     datetime              NOT NULL,
  updated_at     datetime              NOT NULL,
  full_name      VARCHAR(256)          NOT NULL,
  preferred_name VARCHAR(256)          NOT NULL,
  email          VARCHAR(254)          NOT NULL,
  birthdate      datetime              NOT NULL,
  location       VARCHAR(256)          NULL,
  biography      VARCHAR(500)          NULL,
  about          VARCHAR(256)          NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);
