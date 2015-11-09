SELECT SIGLA_PARTIDO, BENEFIC, CPF_CNPJ, COTA, MES_ANO, CONCAT('R$ ', REPLACE(REPLACE(REPLACE(FORMAT(MAX(VALOR), 2),'.',';'),',','.'),';',',')) AS VALOR_MOEDA FROM (
SELECT D.Sigla AS SIGLA_PARTIDO,  C.nome AS COTA, CONCAT(N.mes,'/',N.Ano) AS "MES_ANO",  SUM(N.valor) AS VALOR , count(*) as QTD_REEMBOLSO , N.beneficiario AS BENEFIC,IFNULL(N.cpfCnpj,'?') AS CPF_CNPJ, N.numeroDocumento
  FROM NotaFiscal N , Parlamentar P , Cota C , Partido D
  WHERE N.cotaid = C.cotaid AND N.parlamentarid = P.parlamentarid AND P.partidoid = D.partidoid
GROUP BY P.nome , C.nome , N.mes) AS GRP GROUP BY COTA , MES_ANO ORDER BY 1,4,5,6 DESC