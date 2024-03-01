REM   Script: Exercicio 1 - Script Questão 1 SQL/Prático
REM   exercicio completo

-- Exercicio 1 criação Tabela produto
CREATE TABLE produto ( 
    idproduto NUMBER PRIMARY KEY, 
    codigointerno VARCHAR2(60), 
    descr VARCHAR(120), 
	ativo CHAR(1)     
);

-- Exercicio 1 criação Tabela Embalagem
CREATE TABLE embalagem( 
    idproduto NUMBER, 
    barra VARCHAR2(32), 
    descr VARCHAR2(80), 
    fatorconversao NUMBER, 
    altura NUMBER, 
    largura NUMBER, 
    comprimento NUMBER, 
    ativo CHAR(1), 
    CONSTRAINT embalagem_pk PRIMARY KEY (idproduto, barra), 
    CONSTRAINT embalagem_fk FOREIGN KEY (idproduto) REFERENCES produto(idproduto) 
);

-- Exercicio 1 inserção de dados produto
INSERT ALL 
    INTO produto (idproduto, codigointerno, descr, ativo) VALUES (12, '000001', 'OLEO DE SOJA', 'S') 
    INTO produto (idproduto, codigointerno, descr, ativo) VALUES (13, '000002', 'OLEO DE GIRASSOL', 'S') 
    INTO produto (idproduto, codigointerno, descr, ativo) VALUES (57, '000003', 'TELEFONE SEM FIO', 'S') 
    INTO produto (idproduto, codigointerno, descr, ativo) VALUES (382, '000004', 'MOUSE MICROSOFT', 'S') 
    INTO produto (idproduto, codigointerno, descr, ativo) VALUES (435, '000005', 'JOHNNIE WALKER BLUE LABEL', 'S') 
SELECT * FROM dual;

-- Exercicio 1 inserção de dados embalagem
INSERT ALL 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (12, '7891000315507', 'OLEO DE SOJA LT', 1, 200, 100, 100, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (12, '7891000315508', 'OLEO DE SOJA CX COM 10', 10, 250, 400, 400, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (13, '7891000415510', 'OLEO DE GIRASSOL LT', 1, 200, 100, 100, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (13, '7891000415511', 'OLEO DE GIRASSOL CX COM 10', 10, 250, 400, 400, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (57, '7891000415515', 'TELEFONE SEM FIO', 1, 170, 180, 190, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (382, '7891000715501', 'MOUSE MICROSOFT', 1, 60, 60, 110, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (382, '7891000715502', 'MOUSE MICROSOFT CX COM 10', 10, 180, 200, 200, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (382, '7891000715503', 'MOUSE MICROSOFT CX COM 50', 50, 400, 450, 450, 'N') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (435, '7891000745678', 'JOHNNIE WALKER BLUE LABEL', 1, 300, 150, 150, 'S') 
    INTO embalagem (IDPRODUTO, BARRA, DESCR, FATORCONVERSAO, ALTURA, LARGURA, COMPRIMENTO, ATIVO) 
    VALUES (435, '7891000745679', 'JOHNNIE WALKER BLUE LABEL CX COM 12', 12, 350, 450, 450, 'S') 
SELECT * FROM dual;

-- Exercicio 1 Questão A
SELECT * FROM produto 
FETCH FIRST 10 ROWS ONLY;

-- Exercicio 1 Questão B
SELECT * FROM produto p 
WHERE EXISTS( 
    SELECT 1 FROM embalagem e 
    WHERE 
    p.idproduto = e.idproduto 
    AND 
    e.ativo = 'S' 
) AND NOT EXISTS ( 
    SELECT 1 
    FROM embalagem e2 
    WHERE e2.idproduto = p.idproduto 
    AND e2.ativo <> 'S' 
);

-- Exercicio 1 Questão C
SELECT COUNT(*) AS qtdEmbalagem, p.idproduto FROM produto p 
INNER JOIN embalagem e on(e.idproduto = p.idproduto) 
GROUP BY p.idproduto;

-- Exercicio 1 Questão D
INSERT INTO produto VALUES (500,000006,'MACBOOK','S');
INSERT INTO embalagem VALUES (500,7891000785679,'MACBOOK M1', 1,500,500,300,'S');

-- Exercicio 1 Questão E
UPDATE embalagem 
SET altura = 250, 
    largura = 120, 
    comprimento = 150 
WHERE fatorconversao = 1;

