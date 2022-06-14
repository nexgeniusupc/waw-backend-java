CREATE TABLE companies
(
  id         BIGINT AUTO_INCREMENT NOT NULL,
  created_at datetime              NOT NULL,
  updated_at datetime              NOT NULL,
  name       VARCHAR(100)          NOT NULL,
  address    VARCHAR(256)          NULL,
  email      VARCHAR(256)          NOT NULL,
  CONSTRAINT pk_companies PRIMARY KEY (id)
);

ALTER TABLE companies
  ADD CONSTRAINT uc_companies_name UNIQUE (name);
