CREATE TABLE IF NOT EXISTS `familia` (
  `familia_id` INT NOT NULL AUTO_INCREMENT,
  `familia_nome_responsavel1` VARCHAR(45) NOT NULL,
  `familia_nome_responsavel2` VARCHAR(45),
  `familia_cpf_responsavel1` VARCHAR(14) NOT NULL,
  `familia_cpf_responsavel2` VARCHAR(14),
  `familia_qtd_filhos` INT NOT NULL,
  `familia_contato` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`familia_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `pessoa` (
  `pessoa_id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_nome` VARCHAR(45) NOT NULL,
  `pessoa_cpf` VARCHAR(14) NOT NULL,
  `pessoa_genero` VARCHAR(45) NOT NULL,
  `pessoa_rua` VARCHAR(45) NOT NULL,
  `pessoa_bairro` VARCHAR(45) NOT NULL,
  `pessoa_cidade` VARCHAR(45) NOT NULL,
  `pessoa_estado` VARCHAR(2) NOT NULL,
  `Pessoa_nascimento` DATE NOT NULL,
  `pessoa_nr_residencia` VARCHAR(45) NOT NULL,
  `pessoa_contato` VARCHAR(45) NOT NULL,
  `pessoa_email` VARCHAR(45) NOT NULL,
  `pessoa_cep` VARCHAR(9) NOT NULL,
  `pessoa_usuario` VARCHAR(45) NOT NULL,
  `pessoa_senha` VARCHAR(45) NOT NULL,  
  `pessoa_familia_id` INT NOT NULL,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `pessoa_familia_id`
    FOREIGN KEY (`pessoa_familia_id`)
    REFERENCES `familia` (`familia_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `relatorio` (
  `relatorio_familia_id` INT NOT NULL,
  `relatorio_necessidades` VARCHAR(45) NOT NULL,
  `relatorio_renda` FLOAT NOT NULL,
  `relatorio_nivel_vulnerabilidade` INT NOT NULL,
  `relatorio_data` DATE NOT NULL,
  `relatorio_data_visita` DATE,
  PRIMARY KEY (`relatorio_familia_id`),
  CONSTRAINT `fk_familia_relatorio`
    FOREIGN KEY (`relatorio_familia_id`)
    REFERENCES `familia` (`familia_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `apoio` (
  `apoio_id` INT NOT NULL AUTO_INCREMENT,
  `apoio_nome` VARCHAR(45) NOT NULL,
  `apoio_instituicao` VARCHAR(45) NOT NULL,
  `apoio_descricao` VARCHAR(500) NOT NULL,
  `apoio_familias_id` INT NOT NULL,
  `apoio_data_inicio` DATE NOT NULL,
  `apoio_data_termino` DATE,
  PRIMARY KEY (`apoio_id`),
  CONSTRAINT `apoio_familia_id`
    FOREIGN KEY (`apoio_familias_id`)
    REFERENCES `familia` (`familia_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `funcionario` (
  `funcionario_id` INT NOT NULL AUTO_INCREMENT,
  `funcionario_nome` VARCHAR(45) NOT NULL,
  `funcionario_email` VARCHAR(45) NOT NULL,
  `funcionario_cpf` VARCHAR(14) NOT NULL,
  `funcionario_contato` VARCHAR(45) NOT NULL,
  `funcionario_funcao` VARCHAR(45) NOT NULL,
  `funcionario_senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`funcionario_id`))
ENGINE = InnoDB;
