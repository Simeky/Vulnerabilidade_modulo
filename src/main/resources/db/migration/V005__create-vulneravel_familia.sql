CREATE TABLE IF NOT EXISTS `vulneravel_familia` (

  `familia_id` INT NOT NULL,
  `vulneravel_pessoa_id` INT NOT NULL,

  PRIMARY KEY (`familia_id`, `vulneravel_pessoa_id`),
  CONSTRAINT `fk_familia_id`
    FOREIGN KEY (`familia_id`)
    REFERENCES `familia` (`familia_id`),
  CONSTRAINT `fk_vulneravel_id`
    FOREIGN KEY (`vulneravel_pessoa_id`)
    REFERENCES `vulneravel` (`vulneravel_pessoa_id`))
ENGINE = InnoDB;