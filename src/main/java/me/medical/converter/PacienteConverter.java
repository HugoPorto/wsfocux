package me.medical.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.medical.controller.dto.PacienteDTO;
import me.medical.model.paciente.PacienteModel;

@Component
public class PacienteConverter 
{
	public List<PacienteDTO> entityToDto(List<PacienteModel> paciente) 
	{
		return paciente.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public PacienteDTO entityToDto(PacienteModel paciente) 
	{
		ModelMapper mapper = new ModelMapper();
		PacienteDTO map = mapper.map(paciente, PacienteDTO.class);
		return map;
	}
	
	public PacienteModel dtoToEntity(PacienteDTO dto) 
	{
		ModelMapper mapper = new ModelMapper();
		PacienteModel map = mapper.map(dto, PacienteModel.class);
		return map;
	}
}
