package me.medical.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import me.medical.model.usuario.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
}