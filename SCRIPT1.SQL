
-- Cria tabela de exame nf
CREATE TABLE exame_nf ( 
    id_nf NUMBER PRIMARY KEY, 
    numero NUMBER, 
    data_cadastro DATE, 
    total_geral NUMBER 
);

-- Cria tabela de exame item nf
CREATE TABLE exame_item_nf( 
    id_item_nf NUMBER, 
    id_nf NUMBER, 
    id_produto NUMBER, 
    qtde NUMBER, 
    valor NUMBER, 
    CONSTRAINT pk_id_item_nf PRIMARY KEY (id_item_nf, id_nf), 
    CONSTRAINT fk_id_nf FOREIGN KEY (id_nf) REFERENCES exame_nf(id_nf) 
);


