package ws.system.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.system.model.usuario.PerfilModel;

public interface PerfilRepository extends JpaRepository<PerfilModel, Integer> {

}
