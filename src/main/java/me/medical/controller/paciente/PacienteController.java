package me.medical.controller.paciente;

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
import me.medical.converter.paciente.PacienteConverter;
import me.medical.model.paciente.PacienteModel;
import me.medical.repository.paciente.PacienteRepository;
import me.medical.service.paciente.PacienteService;

/**
 * 
 * @author Hugo Porto
 *
 */
@RestController
@RequestMapping("/wsmedical_api1")
public class PacienteController 
{
	private final PacienteService pacienteService;
	
	@Autowired 
	PacienteConverter pacienteConverter;
	
	@Autowired 
	public PacienteController(PacienteService pacienteService) 
	{
		this.pacienteService = pacienteService;
	}
	
	/**
	 * Salva
	 * @param dto
	 * @return
	 */
	@PostMapping("/paciente/salvar")
	public PacienteDTO save(@RequestBody PacienteDTO  dto) 
	{
		PacienteModel paciente = pacienteConverter.dtoToEntity(dto);
		paciente = pacienteService.save(paciente);
		return pacienteConverter.entityToDto(paciente);
	}

	/**
	 * Lista
	 * @return
	 */
	@GetMapping("/pacientes")
	public List<PacienteDTO> listaPacientesDTO() 
	{
		List<PacienteModel> findAll = pacienteService.getPacientes();
		return pacienteConverter.entityToDto(findAll);
	}
	
	/**
	 * Atualiza
	 * @param dto
	 * @return
	 */
	@PostMapping("/paciente/editar")
	public PacienteDTO edit(@RequestBody PacienteDTO  dto) 
	{
		PacienteModel paciente = pacienteConverter.dtoToEntity(dto);
		paciente = pacienteService.save(paciente);
		return pacienteConverter.entityToDto(paciente);
	}
	
	/**
	 * Deleta
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/paciente/delete/{id}")
    public ResponseEntity<PacienteDTO> delete(@PathVariable final Integer id) throws Exception
	{
        PacienteModel paciente = pacienteService.delete(id);
        return new ResponseEntity<>(pacienteConverter.entityToDto(paciente), HttpStatus.OK);
    }
	
	@GetMapping("/paciente/{id}")
	public PacienteDTO pacienteDTO(@PathVariable final Integer id) {
		PacienteModel paciente = null;
		
		try {
			paciente = pacienteService.getPaciente(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pacienteConverter.entityToDto(paciente);
	}
}
