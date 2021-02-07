package me.medical.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="perfil")
public class PerfilModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String perfil;
	private Date data_criacao;
	private Date data_modificacao;
	
	@OneToMany
	private List<UsuarioModel> usuarios;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	public Date getData_modificacao() {
		return data_modificacao;
	}
	public void setData_modificacao(Date data_modificacao) {
		this.data_modificacao = data_modificacao;
	}
	public List<UsuarioModel> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}
}
