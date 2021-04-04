package me.medical.converter.paciente;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.medical.controller.dto.DadosContatoPacienteDTO;
import me.medical.model.paciente.DadosContatoPacienteModel;

@Component
public class DadosContatoPacienteConverter 
{

	public List<DadosContatoPacienteDTO> entityToDto(List<DadosContatoPacienteModel> dadosContatoPacienteModel)
	{
		return dadosContatoPacienteModel.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public DadosContatoPacienteDTO entityToDto(DadosContatoPacienteModel dadosContatoPacienteModel) 
	{
		ModelMapper mapper = new ModelMapper();
		DadosContatoPacienteDTO map = mapper.map(dadosContatoPacienteModel, DadosContatoPacienteDTO.class);
		return map;
	}
	
	public DadosContatoPacienteModel dtoToEntity(DadosContatoPacienteDTO dto) 
	{
		ModelMapper mapper = new ModelMapper();
		DadosContatoPacienteModel map = mapper.map(dto, DadosContatoPacienteModel.class);
		return map;
	}
}
