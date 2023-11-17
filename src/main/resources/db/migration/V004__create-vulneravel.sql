CREATE TABLE IF NOT EXISTS `vulneravel` (
  `vulneravel_pessoa_id` INT NOT NULL,
  `vulneravel_esta_trabalhando` BOOLEAN NOT NULL,
  `vulneravel_trabalho` VARCHAR(45),
  `vulneravel_salario` FLOAT,
  `vulneravel_familia_id` INT NOT NULL,
  PRIMARY KEY (`vulneravel_pessoa_id`),
  CONSTRAINT `fk_pessoa_vulneravel_id`
    FOREIGN KEY (`vulneravel_pessoa_id`)
    REFERENCES `pessoa` (`pessoa_id`),
  CONSTRAINT `fk_familia_vulneravel_id`
    FOREIGN KEY (`vulneravel_familia_id`)
    REFERENCES `familia` (`familia_id`))
ENGINE = InnoDB;