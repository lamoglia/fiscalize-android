<?php
include_once INCLUDE_ROOT.'/framework/base/BaseDAO.class.php';
include_once INCLUDE_ROOT.'/models/NotaFiscal.class.php';
include_once INCLUDE_ROOT.'/models/Fiscalizacao.class.php';
include_once INCLUDE_ROOT.'/exceptions/NotaFiscalException.class.php';
include_once INCLUDE_ROOT.'/exceptions/FiscalizacaoException.class.php';

class FiscalizeDAO extends BaseDAO {
	
	public function __construct_conectado($conexao = null) {
		parent::__construct_conectado($conexao);
	}

	public function __construct() {
		parent::__construct();
	}
	
	public function consultarNotaFiscal($notaFiscalId) {
		
		$sql = "SELECT notaFiscalId, Partido.sigla as partido, Parlamentar.nome as parlamentar, Parlamentar.ideCadastro as ideCadastro, Cota.nome as cota, Uf.sigla as uf, dataEmissao, descricao, descricaoSubCota, beneficiario, "
				."cpfCnpj, ano, mes, numeroDocumento, parcela, tipoDocumentoFiscal, nomePassageiro, trechoViagem, valor, valorGlosa, valorLiquido, dataInclusao" 
				." FROM NotaFiscal, Partido, Parlamentar, Uf, Cota " 
				." WHERE" 
					." NotaFiscal.parlamentarId = Parlamentar.parlamentarId AND"
				    ." NotaFiscal.ufId = Uf.ufId AND"
				    ." NotaFiscal.cotaId = Cota.cotaId AND"
				    ." Parlamentar.partidoId = Partido.partidoId AND"
				    ." NotaFiscal.notaFiscalId = ?";
		
		if($statement = parent::preparar($sql)) {
			try {
				$statement->bind_param('i', $notaFiscalId);
				$statement->execute();
				$statement->bind_result($notaFiscalId, $partido, $parlamentar, $ideCadastro, $cota, $uf, $dataEmissao, $descricao, $descricaoSubCota, $beneficiario, $cpfCnpj, $ano, $mes, $numeroDocumento,
							$parcela, $tipoDocumentoFiscal, $nomePassageiro, $trechoViagem, $valor, $valorGlosa, $valorLiquido, $dataInclusao);
				
				if ($statement->fetch()) {
					$notaFiscal = new NotaFiscal();
					$notaFiscal->popular($notaFiscalId, $partido, $parlamentar, $ideCadastro, $cota, $uf, $dataEmissao, $descricao, $descricaoSubCota, $beneficiario, $cpfCnpj, $ano, $mes, $numeroDocumento,
							$parcela, $tipoDocumentoFiscal, $nomePassageiro, $trechoViagem, $valor, $valorGlosa, $valorLiquido, $dataInclusao);
				} else {
					throw new NenhumaNotaFiscalEncontradaException();
				}
				$statement->free_result();
			} catch (Exception $e) {
				throw new ConsultarNotasFiscaisException();
			}
		} else {
			throw new SQLException($sql);
		}
		$statement->close();
		
		return $notaFiscal;
	}

	public function consultarFiscalizacoes() {
		
		$sql = "SELECT suspeitas.notaFiscalId as notaFiscalId, suspeitas.soma as somaSuspeitas, confiaveis.soma as somaConfiaveis, suspeitas.soma+confiaveis.soma as somaFiscalizacoes, if(confiaveis.soma=0,'0',suspeitas.soma/confiaveis.soma) as razaoConfiaveis"
			  ." FROM"
				." (SELECT COUNT(*) as soma, notaFiscalId FROM Suspeita WHERE suspeita=false GROUP BY notaFiscalId) as confiaveis" 
				." LEFT OUTER JOIN"
				." 	(SELECT COUNT(*) as soma, notaFiscalId FROM Suspeita WHERE suspeita=true GROUP BY notaFiscalId) as suspeitas"
				." ON suspeitas.notaFiscalId = confiaveis.notaFiscalId"
				." ORDER BY razaoConfiaveis DESC, somaFiscalizacoes DESC, notaFiscalId"
				." LIMIT 100";
		
		$fiscalizacoes = array();
		if($statement = parent::preparar($sql)) {
			try {
				$statement->execute();
				$statement->bind_result($notaFiscalId, $somaSuspeitas, $somaConfiaveis, $somaFiscalizacoes, $razaoConfiaveis); 
				while ($statement->fetch()) {
					$fiscalizacao = new Fiscalizacao();
					$fiscalizacao->popular($notaFiscalId, $somaSuspeitas, $somaConfiaveis, $somaFiscalizacoes, $razaoConfiaveis);
					$fiscalizacoes[] = $fiscalizacao;
				}
				$statement->free_result();
			} catch (Exception $e) {
				throw new ConsultarNotasFiscaisException();
			}
		} else {
			throw new SQLException($sql);
		}
		$statement->close();
		return $fiscalizacoes;
	}
	
}
?>