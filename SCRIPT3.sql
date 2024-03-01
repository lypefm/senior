CREATE OR REPLACE PROCEDURE definir_valores IS
BEGIN
	UPDATE exame_item_nf SET valor = FLOOR(DBMS_RANDOM.VALUE(1, 101));
	UPDATE exame_nf en SET total_geral = (SELECT SUM(valor) FROM exame_item_nf ein WHERE ein.id_nf = en.id_nf);
	COMMIT;
END definir_valores;