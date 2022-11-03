package ws.system.controller.dto;

import java.util.Date;

public class PerfilDTO {
	private int id;
	private String perfil;
	private Date data_criacao;
	private Date data_modificacao;
	
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
}
