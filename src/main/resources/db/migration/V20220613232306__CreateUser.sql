CREATE TABLE users
(
  id             BIGINT AUTO_INCREMENT NOT NULL,
  created_at     datetime NOT NULL,
  updated_at     datetime NOT NULL,
  full_name      VARCHAR(255) NULL,
  preferred_name VARCHAR(255) NULL,
  email          VARCHAR(255) NULL,
  birthdate      datetime NULL,
  location       VARCHAR(255) NULL,
  biography      VARCHAR(255) NULL,
  about          VARCHAR(255) NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
  ADD CONSTRAINT uc_users_fullname UNIQUE (full_name);
