package ws.system.service.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.system.model.paciente.PacienteModel;
import ws.system.repository.paciente.PacienteRepository;

/**
 * 
 * @author Hugo Porto
 *
 */
@Service 
public class PacienteService
{
	private PacienteRepository pacienteRepository;

	/**
	 * Construtor que recebe o repository do paciente
	 * @param pacienteRepository
	 */
	@Autowired
	public PacienteService(PacienteRepository pacienteRepository) 
	{
		this.pacienteRepository = pacienteRepository;
	}

	/**
	 * Deleta um paciente
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PacienteModel delete(int id) throws Exception 
	{
		PacienteModel paciente = getPaciente(id);
		pacienteRepository.delete(paciente);
		
		return paciente;
	}

	/**
	 * Retorna um paciente pelo id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PacienteModel getPaciente(int id) throws Exception 
	{
		return pacienteRepository.findById(id).orElseThrow(() -> new Exception("Paciente não encontrado - " + id));
	}

	/**
	 * Lista todos os pacientes
	 */
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
