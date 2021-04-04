package me.medical.controller.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.medical.controller.dto.DadosContatoPacienteDTO;
import me.medical.converter.paciente.DadosContatoPacienteConverter;
import me.medical.model.paciente.DadosContatoPacienteModel;
import me.medical.service.paciente.DadosContatoPacienteService;

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
