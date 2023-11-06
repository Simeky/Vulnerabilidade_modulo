DROP TABLE relatorio;

ALTER TABLE familia ADD 
  `familia_renda` FLOAT NOT NULL,
  `familia_necessidades` VARCHAR(45),
  `familia_nivel_vulnerabilidade` INT,
  `familia_data_visita` DATE;

ALTER TABLE pessoa ADD 
  `pessoa_deficiencia_tipo` VARCHAR(6),
  `pessoa_deficiencia` VARCHAR(45),
  `pessoa_esta_trabalhando` BOOLEAN NOT NULL,
  `pessoa_trabalho` VARCHAR(45),
  `pessoa_salario` FLOAT;