package ws.system.controller.paciente;

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

import ws.system.controller.dto.PacienteDTO;
import ws.system.converter.paciente.PacienteConverter;
import ws.system.model.paciente.PacienteModel;
import ws.system.service.paciente.PacienteService;

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
	 * Salva o [paciente]
	 * @param dto
	 * @return
	 */
	@PostMapping("/paciente/salva-paciente")
	public PacienteDTO salvaPaciente(@RequestBody PacienteDTO  dto) 
	{
		PacienteModel paciente = pacienteConverter.dtoToEntity(dto);
		paciente = pacienteService.save(paciente);
		return pacienteConverter.entityToDto(paciente);
	}

	/**
	 * Lista os [pacientes]
	 * @return
	 */
	@GetMapping("/lista-pacientes")
	public List<PacienteDTO> listaPacientesDTO() 
	{
		List<PacienteModel> findAll = pacienteService.getPacientes();
		return pacienteConverter.entityToDto(findAll);
	}
	
	/**
	 * Atualiza um [paciente]
	 * @param dto
	 * @return
	 */
	@PostMapping("/paciente/editar-paciente")
	public PacienteDTO editaPaciente(@RequestBody PacienteDTO  dto) 
	{
		PacienteModel paciente = pacienteConverter.dtoToEntity(dto);
		paciente = pacienteService.save(paciente);
		return pacienteConverter.entityToDto(paciente);
	}
	
	/**
	 * Deleta um [paciente]
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/paciente/apaga-paciente/{id}")
    public ResponseEntity<PacienteDTO> delete(@PathVariable final Integer id) throws Exception
	{
        PacienteModel paciente = pacienteService.delete(id);
        return new ResponseEntity<>(pacienteConverter.entityToDto(paciente), HttpStatus.OK);
    }
	
	/**
	 * Retorna um [paciente]
	 * @param id
	 * @return
	 */
	@GetMapping("/retorna-um-paciente/{id}")
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
