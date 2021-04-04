package me.medical.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import me.medical.model.paciente.DadosContatoPacienteModel;

public interface DadosContatoPacienteRepository extends JpaRepository<DadosContatoPacienteModel, Integer>{

}
