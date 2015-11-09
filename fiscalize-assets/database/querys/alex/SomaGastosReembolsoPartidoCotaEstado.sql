SELECT E.Sigla AS ESTADO, D.Sigla AS SIGLA_PARTIDO,  C.nome AS COTA, COUNT(*) QTD_NF, CONCAT('R$ ', REPLACE(REPLACE(REPLACE(FORMAT(SUM(VALOR), 2),'.',';'),',','.'),';',',')) AS VALOR_MOEDA, SUM(VALOR) AS VALOR
FROM NotaFiscal N     , Parlamentar P     , Cota C     , Partido D     , Uf E
  WHERE N.cotaid = C.cotaid    AND N.parlamentarid = P.parlamentarid    AND P.partidoid = D.partidoid    AND N.ufid = E.ufid
GROUP BY D.Sigla , C.nome ORDER BY 2,6 DESC