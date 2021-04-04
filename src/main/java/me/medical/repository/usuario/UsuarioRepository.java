package me.medical.repository.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.medical.model.usuario.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
	
	List<UsuarioModel> findByRazaoSocialContains(String razao_social);
	
	@Query("select u from usuario u where u.nomeDoResponsavel = ?1")
	List<UsuarioModel> findByNomeResponsavel(String nome_responsavel);
}