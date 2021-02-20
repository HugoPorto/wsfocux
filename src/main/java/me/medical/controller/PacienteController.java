package me.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.medical.model.paciente.PacienteModel;
import me.medical.repository.PacienteRepository;

@RestController
@RequestMapping("/api")
public class PacienteController {
	@Autowired private PacienteRepository pacienteRepository;
	
	@GetMapping("/pacientes")
	public List<PacienteModel> listaPaientes(){
		return pacienteRepository.findAll();
	}
}
