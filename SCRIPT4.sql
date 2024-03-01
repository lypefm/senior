SELECT en.data_cadastro, COUNT(*) AS contagemDia FROM exame_nf en
WHERE EXISTS (SELECT 1 FROM exame_item_nf ein
    	WHERE valor < 50 AND
    	ein.id_nf = en.id_nf)
GROUP BY data_cadastro
ORDER BY 1;