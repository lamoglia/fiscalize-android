SELECT COUNT(*) as fiscalizacoes, notaFiscalId 
FROM fiscalize.Suspeita
GROUP BY notaFiscalId
ORDER BY fiscalizacoes DESC