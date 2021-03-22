package me.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.medical.controller.dto.PacienteDTO;
import me.medical.converter.PacienteConverter;
import me.medical.model.paciente.PacienteModel;
import me.medical.repository.PacienteRepository;
import me.medical.service.PacienteService;

@RestController
@RequestMapping("/wsmedical_api1")
public class PacienteController 
{
	private final PacienteService pacienteService;
	
	@Autowired PacienteConverter converter;
	@Autowired public PacienteController(PacienteService pacienteService) 
	{
		this.pacienteService = pacienteService;
	}
	
	@GetMapping("/pacientes")
	public List<PacienteDTO> listaPacientesDTO() 
	{
		List<PacienteModel> findAll = pacienteService.getPacientes();
		return converter.entityToDto(findAll);
	}
	
	@PostMapping("/paciente/salvar")
	public PacienteDTO save(@RequestBody PacienteDTO  dto) 
	{
		PacienteModel paciente = converter.dtoToEntity(dto);
		paciente = pacienteService.save(paciente);
		return converter.entityToDto(paciente);
	}
	
	@DeleteMapping("/paciente/delete/{id}")
    public ResponseEntity<PacienteDTO> delete(@PathVariable final Integer id) throws Exception
	{
        PacienteModel paciente = pacienteService.delete(id);
        return new ResponseEntity<>(converter.entityToDto(paciente), HttpStatus.OK);
    }
}
