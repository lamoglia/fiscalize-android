SELECT suspeitas.notaFiscalId, suspeitas.soma as somaSuspeitas, confiaveis.soma as somaConfiaveis, suspeitas.soma+confiaveis.soma as somaFiscalizacoes, if(confiaveis.soma=0,"0",suspeitas.soma/confiaveis.soma) as razaoConfiaveis
FROM
(SELECT COUNT(*) as soma, notaFiscalId FROM Suspeita WHERE suspeita=false GROUP BY notaFiscalId) as confiaveis 
LEFT OUTER JOIN
(SELECT COUNT(*) as soma, notaFiscalId FROM Suspeita WHERE suspeita=true GROUP BY notaFiscalId) as suspeitas
ON suspeitas.notaFiscalId = confiaveis.notaFiscalId
ORDER BY razaoConfiaveis DESC, somaFiscalizacoes DESC