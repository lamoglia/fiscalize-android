SELECT SIGLA_PARTIDO, PARLAMENTAR, COTA, SUM(QTD_REEMBOLSO) AS QTD_NF , CONCAT('R$ ', REPLACE(REPLACE(REPLACE(FORMAT(MAX(VALOR), 2),'.',';'),',','.'),';',',')) AS VALOR_MOEDA FROM (
SELECT D.Sigla AS SIGLA_PARTIDO, P.nome as PARLAMENTAR, C.nome AS COTA, COUNT(*) QTD_REEMBOLSO,  SUM(VALOR) AS VALOR
FROM NotaFiscal N , Parlamentar P , Cota C , Partido D
  WHERE N.cotaid = C.cotaid AND N.parlamentarid = P.parlamentarid AND P.partidoid = D.partidoid
GROUP BY D.Sigla , P.nome, C.nome) AS GRP GROUP BY SIGLA_PARTIDO, COTA