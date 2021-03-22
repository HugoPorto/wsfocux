package me.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.medical.model.paciente.PacienteModel;
import me.medical.repository.PacienteRepository;

/**
 * 
 * @author Hugo Porto
 *
 */
@Service public class PacienteService
{
	private PacienteRepository pacienteRepository;

	/**
	 * Construtor.
	 * @param pacienteRepository Repository do paciente.
	 */
	@Autowired public PacienteService(PacienteRepository pacienteRepository) 
	{
		this.pacienteRepository = pacienteRepository;
	}

	public PacienteModel delete(int id) throws Exception 
	{
		PacienteModel paciente = getPaciente(id);
		pacienteRepository.delete(paciente);
		
		return paciente;
	}

	public PacienteModel getPaciente(int id) throws Exception 
	{
		return pacienteRepository.findById(id).orElseThrow(() -> new Exception("Paciente não encontrado - " + id));
	}

	public List<PacienteModel> getPacientes() 
	{
		return pacienteRepository.findAll();
	}
	
	/**
	 * Salva ou atualiza o paciente.
	 * @param paciente PacienteModel do paciente.
	 */
	public PacienteModel save(PacienteModel paciente) 
	{
		return pacienteRepository.save(paciente);
	}
}
