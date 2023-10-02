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
delete from relatorio;

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
alter table funcionario auto_increment = 1;
alter table relatorio auto_increment = 1;

-- -----------------------------------------------------
-- Popula a tabela com a massa de dados de teste
-- -----------------------------------------------------

insert into familia(familia_nome_responsavel1, familia_nome_responsavel2, familia_cpf_responsavel1, familia_cpf_responsavel2, familia_qtd_filhos, familia_contato) values 
('João Alberto Silva', NULL, '046.774.110-77', NULL, 2, '47900000000'), 
('Maria Bezerra', 'José Bezerra', '701.742.440-96', '604.885.820-59', 4, '47911111111'),
('Windersson Menezes', 'Bella Menezes', '979.916.120-74', '600.576.410-13', 1, '84983580499');


insert into pessoa (pessoa_nome, pessoa_cpf, pessoa_genero, pessoa_rua, pessoa_bairro, pessoa_cidade, pessoa_estado, pessoa_nascimento, pessoa_nr_residencia, pessoa_contato, pessoa_email, pessoa_cep, pessoa_usuario, pessoa_senha, pessoa_familia_id) values 
('João Alberto Silva', '046.774.110-77', 'masculino','Rua Vereador Pedro Merizio','Centro', 'Botuverá', 'SC', '1971/08/22', '15', '47900000000', 'joalberto@gmail.com', '88295-970', 'joalberto', '123', 1),
('Maria Bezerra', '701.742.440-96', 'feminino', 'Rua 6-A', 'Parque Residencial Nova Fronteira', 'Gurupi', 'TO', '1991/06/22', '376', '63988426297', 'maria.bez@gmail.com', '77420-400', 'maria_bezerra', '123', 2),
('José Bezerra', '604.885.820-59', 'masculino', 'Rua 6-A', 'Parque Residencial Nova Fronteira', 'Gurupi', 'TO', '1993/02/14', '376', '63936873078', 'jose.bezerra@gmail.com', '77420-400', 'jobezerra', '123', 2),
('Windersson Menezes', '979.916.120-74', 'masculino', 'Rua omar Batista de Lima', 'Pirangi do Norte(Distrito Litoral)', 'Parnamirim', 'RN', '1986/11/15', '916', '84983580499', 'windermene@gmail.com', '59191-770', 'winmene', '123', 3),
('Bella Menezes', '979.916.120-74', 'feminino', 'Rua omar Batista de Lima', 'Pirangi do Norte(Distrito Litoral)', 'Parnamirim', 'RN', '1982/01/30', '916', '84936870499', 'bellazes@gmail.com', '59191-770', 'bellazes', '123', 3);


insert into apoio(apoio_nome, apoio_instituicao, apoio_descricao, apoio_familia_id, apoio_data_inicio, apoio_data_termino) values
('Bolsa Família', 'Governo Federal', 'É um programa de transferência de renda com condicionalidades na saúde e na educação. São elegíveis ao Programa Bolsa Família as famílias inscritas no Cadastro Único em situação de pobreza, com renda per capita até R$ 218,00.', 2, '2023/06/25', null),
('Minha casa, Minha vida', 'Governo Federal', 'É um programa de habitação federal do Brasil ele  subsidia a aquisição da casa ou apartamento próprio para famílias com renda até 1,8 mil reais e facilita as condições de acesso ao imóvel para famílias com renda de até 9 mil.', 1, '2023/08/29', null),
('Seguro desemprego', 'Governo Federal', 'É um direito do trabalhador brasileiro e o valor do seguro desemprego é baseado nos 3 últimos salários recebidos pelo trabalhador. O valor mínimo a receber é um salário mínimo. Porém, também há um limite máximo a receber, que é o teto do seguro-desemprego, no valor de R$ 2.230,97 por mês.', 3, '2023/03/02', '2023/08/02');

INSERT INTO funcionario(funcionario_nome, funcionario_email, funcionario_cpf, funcionario_contato, funcionario_funcao, funcionario_senha)
VALUES 
('João Magalhães', 'joao@gmail.com', '123.456.789-01', '(11) 1234-5678', 'Gerente', 'senha123'),
('Maria Santos', 'maria@gmail.com', '987.654.321-09', '(21) 9876-5432', 'Atendente', 'senha456'),
('Carlos Oliveira', 'carlos@gmail.com', '456.789.123-45', '(31) 5555-5555', 'Desenvolvedor', 'senha789');

INSERT INTO relatorio (relatorio_necessidades, relatorio_renda, relatorio_nivel_vulnerabilidade, relatorio_data, relatorio_familia_id, relatorio_data_visita)
VALUES 
('Necessidades do Relatório 1', 1500.00, 3, '2023-06-11', 1, null),
('Necessidades do Relatório 2', 2500.00, 2, '2023-09-30', 2, '2023-11-17'),
('Necessidades do Relatório 3', 1000.00, 1, '2023-08-04', 3, null);