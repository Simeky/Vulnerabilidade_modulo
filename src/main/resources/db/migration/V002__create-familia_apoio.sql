CREATE TABLE IF NOT EXISTS `familia_apoio` (

  `familia_id` INT NOT NULL,
  `apoio_id` INT NOT NULL,

  PRIMARY KEY (`familia_id`, `apoio_id`),
  CONSTRAINT `pk_familia_id`
    FOREIGN KEY (`familia_id`)
    REFERENCES `familia` (`familia_id`),
  CONSTRAINT `pk_apoio_id`
    FOREIGN KEY (`apoio_id`)
    REFERENCES `apoio` (`apoio_id`))
ENGINE = InnoDB;