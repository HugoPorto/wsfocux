package ws.system.controller.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.system.controller.dto.DadosContatoPacienteDTO;
import ws.system.converter.paciente.DadosContatoPacienteConverter;
import ws.system.model.paciente.DadosContatoPacienteModel;
import ws.system.service.paciente.DadosContatoPacienteService;

/**
 * 
 * @author Hugo Porto
 *
 */
@RestController
@RequestMapping("/wsmedical_api1")
public class DadosContatoPacienteController 
{
	private final DadosContatoPacienteService dadosContatoPacienteService;
	
	@Autowired
	DadosContatoPacienteConverter dadosContatoPacienteConverter;

	@Autowired
	public DadosContatoPacienteController(DadosContatoPacienteService dadosContatoPacienteService) {
		this.dadosContatoPacienteService = dadosContatoPacienteService;
	}
	
	
	@GetMapping("/dadosContatoPaciente")
	public List<DadosContatoPacienteDTO> listaDadosContatoPacientes()
	{
		List<DadosContatoPacienteModel> findAll = dadosContatoPacienteService.getDadosContatoPaciente();
		return dadosContatoPacienteConverter.entityToDto(findAll);
	}
}
