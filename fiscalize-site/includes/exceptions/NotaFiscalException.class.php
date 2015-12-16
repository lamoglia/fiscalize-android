<?php
include_once INCLUDE_ROOT.'/framework/exceptions/ExceptionBase.class.php';

class NotaFiscalException extends ExceptionBase { }

class ConsultarNotasFiscaisException extends NotaFiscalException {
	
	public function __construct($mensagem = null) {
		if($mensagem==null or $mensagem=="") $mensagem = "Não foi possível resgatar as notas fiscais!";
		parent::__construct($mensagem);
	}
	
}

class NenhumaNotaFiscalEncontradaException extends NotaFiscalException {
	
	public function __construct($mensagem = null) {
		if($mensagem==null or $mensagem=="") $mensagem = "Nenhuma Nota Fiscal foi encontrada com os dados fornecidos!";
		parent::__construct($mensagem);
	}
	
}

?>