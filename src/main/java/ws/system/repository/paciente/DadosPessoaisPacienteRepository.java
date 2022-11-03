package ws.system.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.system.model.paciente.DadosPessoaisPacienteModel;

public interface DadosPessoaisPacienteRepository extends JpaRepository<DadosPessoaisPacienteModel, Integer>{

}
