package me.medical.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.medical.controller.dto.UsuarioDTO;
import me.medical.converter.UsuarioConverter;
import me.medical.model.UsuarioModel;
import me.medical.repository.UsuarioCustomRepository;
import me.medical.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;

	@Autowired
	private UsuarioCustomRepository ucr;

	@Autowired
	UsuarioConverter converter;

	@GetMapping("/findAllOne")
	public List<UsuarioModel> listaUsuarios() {
		return ur.findAll();
	}

	@GetMapping("/findAllTwo")
	public List<UsuarioDTO> findAll() {
		List<UsuarioModel> findAll = ur.findAll();
		return converter.entityToDto(findAll);
	}
	
	@GetMapping(path = "/usuario/{id}")
	public ResponseEntity<UsuarioModel> consultar(@PathVariable("id") Integer id) {
		return ur.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/usuario/filter")
	public List<UsuarioDTO> findUserByRazaoSocial(@RequestParam("razaoSocial") String razaoSocial) {
		return this.ur.findByRazaoSocialContains(razaoSocial)
				.stream()
				.map(UsuarioConverter::converter)
				.collect(Collectors.toList());
	}

	@GetMapping("/usuario/filter/responsavel")
	public List<UsuarioDTO> findByNomeResponsavel(@RequestParam("nomeResponsavel") String nomeResponsavel) {
		return ur.findByNomeResponsavel(nomeResponsavel).stream()
				.map(UsuarioConverter::converter)
				.collect(Collectors.toList());
	}

	@GetMapping("/usuario/filter/custom")
	public List<UsuarioDTO> findPersonByCustom(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nomeResponsavel", required = false) String nomeResponsavel) {
		return ucr.find(id, nomeResponsavel).stream()
				.map(UsuarioConverter::converter)
				.collect(Collectors.toList());
	}

	@PostMapping("/save")
	public UsuarioDTO save(@RequestBody UsuarioDTO dto) {
		UsuarioModel usuario = converter.dtoToEntity(dto);
		usuario = ur.save(usuario);
		return converter.entityToDto(usuario);
	}
}