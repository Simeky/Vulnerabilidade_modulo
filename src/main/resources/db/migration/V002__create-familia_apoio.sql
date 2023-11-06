CREATE TABLE IF NOT EXISTS `familia_apoio` (

  `familia_id` INT NOT NULL,
  `apoio_id` INT NOT NULL,

  PRIMARY KEY (`familia_id`, `apoio_id`))
ENGINE = InnoDB;