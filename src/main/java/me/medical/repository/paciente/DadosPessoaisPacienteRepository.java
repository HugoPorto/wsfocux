package me.medical.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import me.medical.model.paciente.DadosPessoaisPacienteModel;

public interface DadosPessoaisPacienteRepository extends JpaRepository<DadosPessoaisPacienteModel, Integer>{

}
