CREATE TABLE offers
(
  id            BIGINT AUTO_INCREMENT NOT NULL,
  created_at    datetime NOT NULL,
  updated_at    datetime NOT NULL,
  title         VARCHAR(255) NULL,
  image         VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  salary_range  VARCHAR(255) NULL,
  status        BIT(1) NULL,
  CONSTRAINT pk_offers PRIMARY KEY (id)
);

ALTER TABLE offers
  ADD CONSTRAINT uc_offers_title UNIQUE (title);
