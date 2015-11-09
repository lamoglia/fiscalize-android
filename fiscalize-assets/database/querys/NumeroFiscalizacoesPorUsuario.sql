SELECT usuarioId, COUNT(*) as fiscalizacoes 
FROM fiscalize.Suspeita
GROUP BY usuarioId
ORDER BY fiscalizacoes DESC