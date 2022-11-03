package ws.system.service.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.system.model.paciente.DadosContatoPacienteModel;
import ws.system.repository.paciente.DadosContatoPacienteRepository;

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
