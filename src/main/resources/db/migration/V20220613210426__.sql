CREATE TABLE companies
(
  id         BIGINT AUTO_INCREMENT NOT NULL,
  created_at datetime NOT NULL,
  updated_at datetime NOT NULL,
  name       VARCHAR(255) NULL,
  address    VARCHAR(255) NULL,
  email      VARCHAR(255) NULL,
  CONSTRAINT pk_companies PRIMARY KEY (id)
);

ALTER TABLE companies
  ADD CONSTRAINT uc_companies_name UNIQUE (name);
