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
public class Dossie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose private Integer dossieId;
	@Expose private String nome;
	@Expose private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	@Expose private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name="usuarioCriacaoId")
	@Expose private Usuario usuarioCriacao;
	
	@OneToMany(mappedBy="dossie", fetch = FetchType.LAZY)
	@Expose private List<AnaliseDossie> analisesDossie;

	public Integer getDossieId() {
		return dossieId;
	}

	public void setDossieId(Integer dossieId) {
		this.dossieId = dossieId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Usuario getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(Usuario usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public List<AnaliseDossie> getAnalisesDossie() {
		return analisesDossie;
	}

	public void setAnalisesDossie(List<AnaliseDossie> analisesDossie) {
		this.analisesDossie = analisesDossie;
	}

}
