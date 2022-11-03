package ws.system.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.system.model.usuario.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
}