package br.net.ops.fiscalize.pro.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
public class Anexo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose private Integer anexoId;
	
	@Expose private String url;
	@Expose private String tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataCriacao;

	@ManyToOne
	@JoinColumn(name="analiseId")
	@Expose private Analise analise;

	public Integer getAnexoId() {
		return anexoId;
	}

	public void setAnexoId(Integer anexoId) {
		this.anexoId = anexoId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Analise getAnalise() {
		return analise;
	}

	public void setAnalise(Analise analise) {
		this.analise = analise;
	}

}
