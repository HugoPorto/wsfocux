package me.medical.controller.dto;

import java.util.Date;

import me.medical.model.usuario.LoginModel;
import me.medical.model.usuario.PerfilModel;

public class UsuarioDTO {
	private int id;
	private String razaoSocial;
	private String nomeDoResponsavel;
	private PerfilModel perfil;
	private LoginModel login;
	private Date dataCriacao;
	private Date dataModificacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeDoResponsavel() {
		return nomeDoResponsavel;
	}

	public void setNomeDoResponsavel(String nomeDoResponsavel) {
		this.nomeDoResponsavel = nomeDoResponsavel;
	}

	public PerfilModel getPerfil() {
		return perfil;
	}
	
	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}

	public LoginModel getLogin() {
		return login;
	}

	public void setLogin(LoginModel login) {
		this.login = login;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
}
