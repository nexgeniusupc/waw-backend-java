CREATE TABLE offers
(
  id            BIGINT AUTO_INCREMENT NOT NULL,
  created_at    datetime              NOT NULL,
  updated_at    datetime              NOT NULL,
  title         VARCHAR(200)          NOT NULL,
  image         VARCHAR(2000)         NULL,
  `description` VARCHAR(4000)         NOT NULL,
  salary_range  VARCHAR(50)           NULL,
  status        BIT(1)                NOT NULL,
  CONSTRAINT pk_offers PRIMARY KEY (id)
);

ALTER TABLE offers
  ADD CONSTRAINT uc_offers_title UNIQUE (title);
