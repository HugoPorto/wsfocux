package ws.system.converter.paciente;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ws.system.controller.dto.DadosPessoaisPacienteDTO;
import ws.system.model.paciente.DadosPessoaisPacienteModel;

@Component
public class DadosPessoaisPacienteConverter 
{

	public List<DadosPessoaisPacienteDTO> entityToDto(List<DadosPessoaisPacienteModel> dadosPessoaisPacienteModel)
	{
		return dadosPessoaisPacienteModel.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public DadosPessoaisPacienteDTO entityToDto(DadosPessoaisPacienteModel dadosPessoaisPacienteModel) 
	{
		ModelMapper mapper = new ModelMapper();
		DadosPessoaisPacienteDTO map = mapper.map(dadosPessoaisPacienteModel, DadosPessoaisPacienteDTO.class);
		return map;
	}
	
	public DadosPessoaisPacienteModel dtoToEntity(DadosPessoaisPacienteDTO dto) 
	{
		ModelMapper mapper = new ModelMapper();
		DadosPessoaisPacienteModel map = mapper.map(dto, DadosPessoaisPacienteModel.class);
		return map;
	}
}
