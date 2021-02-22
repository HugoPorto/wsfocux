package me.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.medical.controller.dto.PacienteDTO;
import me.medical.converter.PacienteConverter;
import me.medical.model.paciente.PacienteModel;
import me.medical.repository.PacienteRepository;

@RestController
@RequestMapping("/wsmedical_api1")
public class PacienteController {
	@Autowired private PacienteRepository pacienteRepository;
	@Autowired PacienteConverter converter;
	
	@GetMapping("/pacientes")
	public List<PacienteModel> listaPaientes(){
		return pacienteRepository.findAll();
	}
	
	@PostMapping("/salvar")
	public PacienteDTO  save(@RequestBody PacienteDTO  dto) {
		PacienteModel paciente = converter.dtoToEntity(dto);
		paciente = pacienteRepository.save(paciente);
		return converter.entityToDto(paciente);
	}
}
