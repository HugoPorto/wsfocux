package me.medical.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import me.medical.model.paciente.PacienteModel;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

}
