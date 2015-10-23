SELECT (suspeitas.soma/confiaveis.soma)*100 FROM
(SELECT COUNT(*) as soma FROM fiscalize.Suspeita WHERE suspeita=true) as suspeitas,
(SELECT COUNT(*) as soma FROM fiscalize.Suspeita WHERE suspeita=false) as confiaveis