package ws.system.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.system.model.paciente.DadosContatoPacienteModel;

public interface DadosContatoPacienteRepository extends JpaRepository<DadosContatoPacienteModel, Integer>{

}
