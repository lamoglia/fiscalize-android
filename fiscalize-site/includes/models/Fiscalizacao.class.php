<?php
class Fiscalizacao {
	
	public $notaFiscalId; 
	public $somaSuspeitas; 
	public $somaConfiaveis; 
	public $somaFiscalizacoes; 
	public $razaoConfiaveis;
	
	public function popular($notaFiscalId, $somaSuspeitas, $somaConfiaveis, $somaFiscalizacoes, $razaoConfiaveis) {
		$this->notaFiscalId = $notaFiscalId;
		$this->somaSuspeitas = $somaSuspeitas;
		$this->somaConfiaveis = $somaConfiaveis;
		$this->somaFiscalizacoes = $somaFiscalizacoes;
		$this->razaoConfiaveis = $razaoConfiaveis;
	}
	
}
?>