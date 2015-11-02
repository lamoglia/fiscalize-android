package br.net.ops.fiscalize.pro.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
public class Analise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose private Integer analiseId;
	
	@Expose private Boolean concluida;
	@Expose private String comentarios;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name="fiscalizacaoId")
	@Expose private Fiscalizacao fiscalizacao;
	
	@ManyToOne
	@JoinColumn(name="usuarioResponsavelId")
	@Expose private Usuario usuarioResponsavel;
	
	@OneToMany(mappedBy="analise")
	@Expose private List<Anexo> anexos;

	@OneToMany(mappedBy="analise", fetch = FetchType.LAZY)
	@Expose private List<AnaliseDossie> analisesDossie;

	public Integer getAnaliseId() {
		return analiseId;
	}

	public void setAnaliseId(Integer analiseId) {
		this.analiseId = analiseId;
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

	public Fiscalizacao getFiscalizacao() {
		return fiscalizacao;
	}

	public void setFiscalizacao(Fiscalizacao fiscalizacao) {
		this.fiscalizacao = fiscalizacao;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public List<AnaliseDossie> getAnalisesDossie() {
		return analisesDossie;
	}

	public void setAnalisesDossie(List<AnaliseDossie> analisesDossie) {
		this.analisesDossie = analisesDossie;
	}
	
}
