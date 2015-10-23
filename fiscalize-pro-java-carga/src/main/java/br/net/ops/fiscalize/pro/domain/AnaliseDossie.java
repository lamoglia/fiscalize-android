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
public class AnaliseDossie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose private Integer analiseDossieId;
	
	@Expose private Boolean concluida;
	@Expose private String comentarios;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name="analiseId")
	@Expose private Analise analise;
	
	@ManyToOne
	@JoinColumn(name="dossieId")
	@Expose private Dossie dossie;
	
	@ManyToOne
	@JoinColumn(name="usuarioAdicionouId")
	@Expose private Usuario usuarioAdicionou;

	public Integer getAnaliseDossieId() {
		return analiseDossieId;
	}

	public void setAnaliseDossieId(Integer analiseDossieId) {
		this.analiseDossieId = analiseDossieId;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Analise getAnalise() {
		return analise;
	}

	public void setAnalise(Analise analise) {
		this.analise = analise;
	}

	public Dossie getDossie() {
		return dossie;
	}

	public void setDossie(Dossie dossie) {
		this.dossie = dossie;
	}

	public Usuario getUsuarioAdicionou() {
		return usuarioAdicionou;
	}

	public void setUsuarioAdicionou(Usuario usuarioAdicionou) {
		this.usuarioAdicionou = usuarioAdicionou;
	}

}
