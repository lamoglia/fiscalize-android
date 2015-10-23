package br.net.ops.fiscalize.pro.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose private Integer usuarioId;
	private String usuario;
	private String senha;
	private String facebookId;
	@Expose private String tokenId;
	private String nome;
	private String email;
	
	@OneToMany(mappedBy="usuarioResponsavel", fetch = FetchType.LAZY)
	@Expose private List<Analise> analises;
	
	@OneToMany(mappedBy="usuarioAdicionou", fetch = FetchType.LAZY)
	@Expose private List<AnaliseDossie> analisesDossie;
	
	@OneToMany(mappedBy="usuarioCriacao", fetch = FetchType.LAZY)
	@Expose private List<Dossie> dossie;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Analise> getAnalises() {
		return analises;
	}

	public void setAnalises(List<Analise> analises) {
		this.analises = analises;
	}

	public List<AnaliseDossie> getAnalisesDossie() {
		return analisesDossie;
	}

	public void setAnalisesDossie(List<AnaliseDossie> analisesDossie) {
		this.analisesDossie = analisesDossie;
	}

	public List<Dossie> getDossie() {
		return dossie;
	}

	public void setDossie(List<Dossie> dossie) {
		this.dossie = dossie;
	}
	
}
