package me.medical.converter.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.medical.controller.dto.UsuarioDTO;
import me.medical.model.usuario.UsuarioModel;

@Component
public class UsuarioConverter {
	public UsuarioDTO entityToDto(UsuarioModel usuario) {
		ModelMapper mapper = new ModelMapper();
		UsuarioDTO map = mapper.map(usuario, UsuarioDTO.class);
		return map;
	}

	public List<UsuarioDTO> entityToDto(List<UsuarioModel> usuario) {
		return usuario.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public UsuarioModel dtoToEntity(UsuarioDTO dto) {
		ModelMapper mapper = new ModelMapper();
		UsuarioModel map = mapper.map(dto, UsuarioModel.class);
		return map;
	}

	public List<UsuarioModel> dtoToEntity(List<UsuarioDTO> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public static UsuarioDTO converter(UsuarioModel usuarioModel) {
        var usuario = new UsuarioDTO();
        usuario.setId(usuarioModel.getId());
        usuario.setRazaoSocial(usuarioModel.getRazaoSocial());
        usuario.setNomeDoResponsavel(usuarioModel.getNomeDoResponsavel());
        return usuario;
    }
	
	public static UsuarioDTO converterWithPerfil(UsuarioModel usuarioModel) {
        var usuario = new UsuarioDTO();
        usuario.setId(usuarioModel.getId());
        usuario.setRazaoSocial(usuarioModel.getRazaoSocial());
        usuario.setNomeDoResponsavel(usuarioModel.getNomeDoResponsavel());
        usuario.setPerfil(usuarioModel.getPerfil());
        return usuario;
    }
}
