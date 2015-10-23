SELECT fiscalizacoes.soma/usuarios.soma FROM
(SELECT COUNT(*) as soma FROM fiscalize.Suspeita) as fiscalizacoes,
(SELECT COUNT(*) as soma FROM fiscalize.Usuario) as usuarios