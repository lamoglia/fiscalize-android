package br.com.cotasparlamentares.cargafiscalize.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cotasparlamentares.cargafiscalize.dao.DespesaDao;
import br.com.cotasparlamentares.cargafiscalize.domain.Despesa;
import br.com.cotasparlamentares.cargafiscalize.exception.CargaDespesaException;
import br.com.cotasparlamentares.cargafiscalize.exception.DespesaReflectionException;
import br.com.cotasparlamentares.cargafiscalize.util.Utilidade;

@Component
public class DatabaseCotasParlamentares {

	private Logger logger;
	
	private long inicio;
	
	@Autowired
	private DespesaDao despesaDao;
	
	public DatabaseCotasParlamentares() {
		this.inicio = System.currentTimeMillis();
		this.logger = Utilidade.getLogger();
	}
	
	@Transactional
	public void carregarBancoDados(List<Despesa> despesas) throws CargaDespesaException, DespesaReflectionException {
		logger.log(Level.INFO, "Iniciando salvamento dos registros no banco de dados...");
		
		long ultimoLog = System.currentTimeMillis();
		int iteracao=0;
		int validos=0;
		for(Despesa despesa:despesas) {
			try {
				despesaDao.save(despesa);
				validos++;
			} catch(HibernateException e) {
				logger.log(Level.WARNING, "Problema ao salvar registro no banco de dados: " + iteracao + " Erro: " + e.getMessage());
			}
			
			iteracao++;
            if(System.currentTimeMillis() - ultimoLog > Utilidade.LOG_INTERVAL) {
            	logger.log(Level.INFO, "Salvando em banco registro " + iteracao);
				ultimoLog = System.currentTimeMillis();
			}
            
		}
		
		logger.log(Level.INFO, "Tempo de salvamento em banco: " + (System.currentTimeMillis()-inicio)/1000 + " segundos");
        logger.log(Level.INFO, "Registros lidos: " + iteracao);
        logger.log(Level.INFO, "Registros válidos: " + validos);
		
	}
	
}