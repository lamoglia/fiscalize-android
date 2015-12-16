<?php
include_once INCLUDE_ROOT.'/framework/exceptions/ExceptionBase.class.php';

class FiscalizacaoException extends ExceptionBase { }

class ConsultarFiscalizacoesException extends FiscalizacaoException {
	
	public function __construct($mensagem = null) {
		if($mensagem==null or $mensagem=="") $mensagem = "Não foi possível resgatar as fiscalizações!";
		parent::__construct($mensagem);
	}
	
}

class NenhumaFiscalizacaoEncontradaException extends FiscalizacaoException {
	
	public function __construct($mensagem = null) {
		if($mensagem==null or $mensagem=="") $mensagem = "Nenhuma Fiscalizacao foi encontrada com os dados fornecidos!";
		parent::__construct($mensagem);
	}
	
}

?>