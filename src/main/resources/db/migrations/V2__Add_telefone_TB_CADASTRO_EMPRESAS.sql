--Migrant para adicionar a coluna de RANK na tabela de cadastros, tabelas de migration são imutáveis
ALTER TABLE TB_CADASTRO_EMPRESAS
ADD COLUMN telefone INT;