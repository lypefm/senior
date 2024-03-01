DECLARE
  -- Declaração de variáveis
  v_id_item_nf NUMBER := 1;
  v_id_nf NUMBER := 1;
BEGIN
  -- Loop FOR
  FOR i IN 1..10 LOOP
    FOR j in 1..100 LOOP
	 INSERT INTO exame_nf VALUES (v_id_nf, (i * 100 + j), CURRENT_DATE + (i - 10), 300);
	 FOR k IN 1..3 LOOP
	 	INSERT INTO exame_item_nf VALUES (v_id_item_nf,v_id_nf,1,1,100);
     	v_id_item_nf := v_id_item_nf + 1;
     END LOOP;
	 v_id_nf := v_id_nf + 1;
    END LOOP;
  END LOOP;
END;