DROP TABLE relatorio;

ALTER TABLE familia 
ADD `familia_renda` FLOAT NOT NULL,
ADD `familia_qtd_membros` INT,
ADD `familia_membros_deficiencia` BOOLEAN NOT NULL,
ADD `familia_necessidades` VARCHAR(45),
ADD `familia_nivel_vulnerabilidade` INT NOT NULL,
ADD `familia_data_visita` DATE;

ALTER TABLE pessoa 
ADD `pessoa_deficiencia_tipo` VARCHAR(6) not null,
ADD `pessoa_deficiencia` VARCHAR(45);

ALTER TABLE funcionario
DROP FOREIGN KEY `fk_pessoa_funcionario_id`;

ALTER TABLE funcionario
DROP COLUMN `funcionario_nome`,
DROP COLUMN `funcionario_email`,
DROP COLUMN `funcionario_cpf`,
DROP COLUMN `funcionario_contato`,
DROP COLUMN `funcionario_senha`;

ALTER TABLE funcionario
ADD COLUMN `funcionario_usuario` VARCHAR(45) not null,
ADD COLUMN `funcionario_senha` VARCHAR(45) not null,
ADD COLUMN `funcionario_departamento` VARCHAR(45) NOT NULL,
ADD COLUMN `funcionario_salario` FLOAT NOT NULL,
ADD COLUMN `funcionario_role` VARCHAR(45) not null;

ALTER TABLE funcionario
ADD CONSTRAINT `fk_pessoa_funcionario_id` 
  FOREIGN KEY (`funcionario_id`)
  REFERENCES `pessoa` (`pessoa_id`);

ALTER TABLE funcionario
CHANGE funcionario_id funcionario_pessoa_id INT;