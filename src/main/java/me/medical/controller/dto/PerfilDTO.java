package me.medical.controller.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDTO {
	private int id;
	private String perfil;
	private Date data_criacao;
	private Date data_modificacao;
}
