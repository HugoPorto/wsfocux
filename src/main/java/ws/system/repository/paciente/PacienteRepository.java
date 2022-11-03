package ws.system.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.system.model.paciente.PacienteModel;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

}
