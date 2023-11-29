-- -----------------------------------------------------
-- Desabilita checks de foreign key
-- -----------------------------------------------------

set foreign_key_checks = 0;

-- -----------------------------------------------------
-- Limpa todas as tabelas
-- -----------------------------------------------------
delete from familia;
delete from pessoa;
delete from apoio;
delete from funcionario;

-- -----------------------------------------------------
-- Habilita checks de foreign key
-- -----------------------------------------------------

set foreign_key_checks = 1;

-- -----------------------------------------------------
-- Tabelas com auto-incremento começam com 1
-- -----------------------------------------------------

alter table familia auto_increment = 1;
alter table pessoa auto_increment = 1;
alter table apoio auto_increment = 1;

-- -----------------------------------------------------
-- Popula a tabela com a massa de dados de teste
-- -----------------------------------------------------

insert into users(login, senha, role) values ("Simeky", "123", "ADMIN");

insert into familia(familia_nome_responsavel1, familia_nome_responsavel2, familia_cpf_responsavel1, familia_cpf_responsavel2, familia_qtd_filhos, familia_contato, familia_renda, familia_necessidades, familia_nivel_vulnerabilidade, familia_data_visita, familia_qtd_membros, familia_membros_deficiencia) values 
('João Alberto Silva', NULL, '046.774.110-77', NULL, 2, '47900000000', 2300, 'Não possuem geladeira', 57, '2023/11/10', 3, FALSE), 
('Maria Bezerra', 'José Bezerra', '701.742.440-96', '604.885.820-59', 4, '47911111111', 2300, 'Não possuem geladeira', 57, '2023/11/10', 6, FALSE),
('Windersson Menezes', 'Bella Menezes', '979.916.120-74', '600.576.410-13', 1, '84983580499', 2300, 'Não possuem geladeira', 57, '2023/11/10', 3, TRUE);


insert into pessoa (pessoa_nome, pessoa_cpf, pessoa_genero, pessoa_rua, pessoa_bairro, pessoa_cidade, pessoa_estado, pessoa_nascimento, pessoa_nr_residencia, pessoa_contato, pessoa_email, pessoa_cep, pessoa_deficiencia_tipo, pessoa_deficiencia) values 
('João Alberto Silva', '046.774.110-77', 'MASCULINO','Rua Vereador Pedro Merizio','Centro', 'Botuverá', 'SC', '1971/08/22', '15', '47900000000', 'joalberto@gmail.com', '88295-970', 'NENHUM', null),
('Maria Bezerra', '701.742.440-96', 'FEMININO', 'Rua 6-A', 'Parque Residencial Nova Fronteira', 'Gurupi', 'TO', '1991/06/22', '376', '63988426297', 'maria.bez@gmail.com', '77420-400', 'NENHUM', null),
('José Bezerra', '604.885.820-59', 'MASCULINO', 'Rua 6-A', 'Parque Residencial Nova Fronteira', 'Gurupi', 'TO', '1993/02/14', '376', '63936873078', 'jose.bezerra@gmail.com', '77420-400', 'NENHUM', null),
('Windersson Menezes', '979.916.120-74', 'MASCULINO', 'Rua omar Batista de Lima', 'Pirangi do Norte(Distrito Litoral)', 'Parnamirim', 'RN', '1986/11/15', '916', '84983580499', 'windermene@gmail.com', '59191-770', 'NENHUM', null),
('Bella Menezes', '979.916.120-74', 'FEMININO', 'Rua omar Batista de Lima', 'Pirangi do Norte(Distrito Litoral)', 'Parnamirim', 'RN', '1982/01/30', '916', '84936870499', 'bellazes@gmail.com', '59191-770', 'NENHUM', null);


insert into apoio(apoio_nome, apoio_instituicao, apoio_descricao, apoio_familias_id, apoio_data_inicio, apoio_data_termino) values
('Bolsa Família', 'Governo Federal', 'É um programa de transferência de renda com condicionalidades na saúde e na educação. São elegíveis ao Programa Bolsa Família as famílias inscritas no Cadastro Único em situação de pobreza, com renda per capita até R$ 218,00.', 2, '2023/06/25', null),
('Minha casa, Minha vida', 'Governo Federal', 'É um programa de habitação federal do Brasil ele  subsidia a aquisição da casa ou apartamento próprio para famílias com renda até 1,8 mil reais e facilita as condições de acesso ao imóvel para famílias com renda de até 9 mil.', 1, '2023/08/29', null),
('Seguro desemprego', 'Governo Federal', 'É um direito do trabalhador brasileiro e o valor do seguro desemprego é baseado nos 3 últimos salários recebidos pelo trabalhador. O valor mínimo a receber é um salário mínimo. Porém, também há um limite máximo a receber, que é o teto do seguro-desemprego, no valor de R$ 2.230,97 por mês.', 3, '2023/03/02', '2023/08/02');

INSERT INTO funcionario(funcionario_pessoa_id, funcionario_funcao, funcionario_departamento, funcionario_salario)
VALUES 
(1, 'Gerente', 'Vendas', 2400),
(5, 'Atendente', 'Marketing', 800),
(3, 'Desenvolvedor', 'TI', 1500);

INSERT INTO vulneravel(vulneravel_pessoa_id, vulneravel_esta_trabalhando, vulneravel_trabalho, vulneravel_salario, vulneravel_familia_id)
VALUES
(2, FALSE, null, null, 3),
(4, FALSE, null, null, 1);


