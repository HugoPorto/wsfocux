package me.medical.service.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.medical.model.paciente.DadosContatoPacienteModel;
import me.medical.repository.paciente.DadosContatoPacienteRepository;

/**
 * 
 * @author Hugo Porto
 *
 */
@Service 
public class DadosContatoPacienteService
{
	private DadosContatoPacienteRepository dadosContatoPacienteRepository;

	@Autowired
	public DadosContatoPacienteService(DadosContatoPacienteRepository dadosContatoPacienteRepository) 
	{
		this.dadosContatoPacienteRepository = dadosContatoPacienteRepository;
	}
	
	public List<DadosContatoPacienteModel> getDadosContatoPaciente()
	{
		return dadosContatoPacienteRepository.findAll();
	}
}
