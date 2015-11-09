SELECT SIGLA_PARTIDO, COTA, CONCAT('R$ ', REPLACE(REPLACE(REPLACE(FORMAT(MAX(VALOR), 2),'.',';'),',','.'),';',',')) AS VALOR_MOEDA, MAX(VALOR) AS VALOR FROM (
SELECT D.Sigla AS SIGLA_PARTIDO,  C.nome AS COTA, CONCAT(N.mes,'/',N.Ano) AS "MES_ANO",  SUM(N.valor) AS VALOR
FROM NotaFiscal N , Parlamentar P , Cota C , Partido D
  WHERE N.cotaid = C.cotaid
    AND N.parlamentarid = P.parlamentarid
    AND P.partidoid = D.partidoid
GROUP BY D.Sigla , C.nome
) AS GRP
GROUP BY COTA
ORDER BY 2,4 DESC