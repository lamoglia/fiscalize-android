package br.net.ops.fiscalize.pro.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
public class Fiscalizacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose private Integer fiscalizacaoId;
	@Expose private Integer notaFiscalId;
	@Expose private Integer numeroSuspeitas;
	@Expose private Integer numeroSuspeitasValor;
	@Expose private Integer numeroSuspeitasObjeto;
	@Expose private Integer numeroSuspeitasBeneficiario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataAtualizacao;
	
	@OneToMany(mappedBy="analise", fetch = FetchType.LAZY)
	@Expose private List<Analise> analises;

	public Integer getFiscalizacaoId() {
		return fiscalizacaoId;
	}

	public void setFiscalizacaoId(Integer fiscalizacaoId) {
		this.fiscalizacaoId = fiscalizacaoId;
	}

	public Integer getNotaFiscalId() {
		return notaFiscalId;
	}

	public void setNotaFiscalId(Integer notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}

	public Integer getNumeroSuspeitas() {
		return numeroSuspeitas;
	}

	public void setNumeroSuspeitas(Integer numeroSuspeitas) {
		this.numeroSuspeitas = numeroSuspeitas;
	}

	public Integer getNumeroSuspeitasValor() {
		return numeroSuspeitasValor;
	}

	public void setNumeroSuspeitasValor(Integer numeroSuspeitasValor) {
		this.numeroSuspeitasValor = numeroSuspeitasValor;
	}

	public Integer getNumeroSuspeitasObjeto() {
		return numeroSuspeitasObjeto;
	}

	public void setNumeroSuspeitasObjeto(Integer numeroSuspeitasObjeto) {
		this.numeroSuspeitasObjeto = numeroSuspeitasObjeto;
	}

	public Integer getNumeroSuspeitasBeneficiario() {
		return numeroSuspeitasBeneficiario;
	}

	public void setNumeroSuspeitasBeneficiario(Integer numeroSuspeitasBeneficiario) {
		this.numeroSuspeitasBeneficiario = numeroSuspeitasBeneficiario;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Analise> getAnalises() {
		return analises;
	}

	public void setAnalises(List<Analise> analises) {
		this.analises = analises;
	}
	
}
