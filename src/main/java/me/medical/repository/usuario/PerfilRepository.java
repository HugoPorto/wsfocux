package me.medical.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import me.medical.model.usuario.PerfilModel;

public interface PerfilRepository extends JpaRepository<PerfilModel, Integer> {

}
