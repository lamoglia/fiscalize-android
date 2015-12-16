<?php
include_once INCLUDE_ROOT.'/daos/FiscalizeDAO.class.php';

class FiscalizeController {
	
	public function consultarNotaFiscal($notaFiscalId) {
		$strHTML = "";
		try {
			$fiscalizeDAO = new FiscalizeDAO();
			$notaFiscal = $fiscalizeDAO->consultarNotaFiscal($notaFiscalId);
			
			$dateEmissao = new DateTime($notaFiscal->dataEmissao);
			$dataEmissao = $dateEmissao->format('d/M/Y');
			
			$strHTML .= "<table border='1'>";
			
			$strHTML .= "<tr><th>ID da Nota Fiscal:</th><td>$notaFiscal->notaFiscalId</td></tr>";
			
			$strHTML .= "<tr><th>Parlamentar:</th><td><img src='http://104.131.229.175/fiscalize/parlamentar/$notaFiscal->ideCadastro.jpg'>$notaFiscal->parlamentar</td></tr>";
			$strHTML .= "<tr><th>Partido:</th><td><img src='http://104.131.229.175/fiscalize/partido/$notaFiscal->partido.gif'>$notaFiscal->partido</td></tr>";
			$strHTML .= "<tr><th>UF:</th><td>$notaFiscal->uf</td></tr>";

			$strHTML .= "<tr><th>Cota:</th><td>$notaFiscal->cota</td></tr>";
			$strHTML .= "<tr><th>Descrição:</th><td>$notaFiscal->descricao</td></tr>";
			$strHTML .= "<tr><th>Data Emissão:</th><td>$dataEmissao</td></tr>";
			
			$strHTML .= "<tr><th>Beneficiário:</th><td>$notaFiscal->beneficiario</td></tr>";
			$strHTML .= "<tr><th>CPF/CPNJ:</th><td>$notaFiscal->cpfCnpj</td></tr>";
			$strHTML .= "<tr><th>Mês/Ano:</th><td>$notaFiscal->mes/$notaFiscal->ano</td></tr>";
			$strHTML .= "<tr><th>Número Documento:</th><td>$notaFiscal->numeroDocumento</td></tr>";
			$strHTML .= "<tr><th>Nome Passageiro:</th><td>$notaFiscal->nomePassageiro</td></tr>";
			$strHTML .= "<tr><th>Trecho Viagem:</th><td>$notaFiscal->trechoViagem</td></tr>";
			$strHTML .= "<tr><th>Valor:</th><td>$notaFiscal->valor</td></tr>";
			
			$strHTML .= "</table>";
			
		} catch(NotaFiscalException $e) {
			$strHTML = $e->getMessage();
		}
		return $strHTML;
	}
	
	public function consultarFiscalizacoes() {
		$strHTML = "";
		try {
			$fiscalizeDAO = new FiscalizeDAO();
			$fiscalizacoes = $fiscalizeDAO->consultarFiscalizacoes();
			
			$strHTML = "<table border='1'>";
			$strHTML .= "<tr>";
			$strHTML .= "<th>ID da Nota Fiscal</th>";
			$strHTML .= "<th>Suspeitas</th>";
			$strHTML .= "<th>Confiaveis</th>";
			$strHTML .= "<th>Total</th>";
			$strHTML .= "<th>Razão</th>";
			$strHTML .= "</tr>";
			
			foreach($fiscalizacoes as $fiscalizacao) {
				$strHTML .= "<tr>";
				$strHTML .= "<td><a href='notafiscal.php?notaFiscalId=$fiscalizacao->notaFiscalId'>$fiscalizacao->notaFiscalId</td>";
				$strHTML .= "<td>$fiscalizacao->somaSuspeitas</td>";
				$strHTML .= "<td>$fiscalizacao->somaConfiaveis</td>";
				$strHTML .= "<td>$fiscalizacao->somaFiscalizacoes</td>";
				$strHTML .= "<td>$fiscalizacao->razaoConfiaveis</td>";
				$strHTML .= "</tr>";
			}
			
			$strHTML .= "</table>";
			
		} catch(FiscalizacaoException $e) {
			$strHTML = $e->getMessage();
		}
		return $strHTML;
	}
	
}
?>