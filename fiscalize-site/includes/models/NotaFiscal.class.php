<?php
class NotaFiscal {
	
	public $notaFiscalId;
	public $parlamentar;
	public $cota;
	public $uf;
	public $dataEmissao;
	public $descricao;
	public $descricaoSubCota;
	public $beneficiario;
	public $cpfCnpj;
	public $ano;
	public $mes;
	public $numeroDocumento;
	public $parcela;
	public $tipoDocumentoFiscal;
	public $nomePassageiro;
	public $trechoViagem;
	public $valor;
	public $valorGlosa;
	public $valorLiquido;
	public $dataInclusao;
	
	public function popular($notaFiscalId, $partido, $parlamentar, $ideCadastro, $cota, $uf, $dataEmissao, $descricao,
			$descricaoSubCota, $beneficiario, $cpfCnpj, $ano, $mes, $numeroDocumento, $parcela,
			$tipoDocumentoFiscal, $nomePassageiro, $trechoViagem, $valor, $valorGlosa, $valorLiquido, $dataInclusao) {
				
		$this->notaFiscalId = $notaFiscalId;
		$this->partido = $partido;
		$this->parlamentar = $parlamentar;
		$this->ideCadastro = $ideCadastro;
		$this->cota = $cota;
		$this->uf = $uf;
		$this->dataEmissao = $dataEmissao;
		$this->descricao = $descricao;
		$this->descricaoSubCota = $descricaoSubCota;
		$this->beneficiario = $beneficiario;
		$this->cpfCnpj = $cpfCnpj;
		$this->ano = $ano;
		$this->mes = $mes;
		$this->numeroDocumento = $numeroDocumento;
		$this->parcela = $parcela;
		$this->tipoDocumentoFiscal = $tipoDocumentoFiscal;
		$this->nomePassageiro = $nomePassageiro;
		$this->trechoViagem = $trechoViagem;
		$this->valor = $valor;
		$this->valorGlosa = $valorGlosa;
		$this->valorLiquido = $valorLiquido;
		$this->dataInclusao = $dataInclusao;
	}
	
}
?>