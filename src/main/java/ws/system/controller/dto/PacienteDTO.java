package ws.system.controller.dto;

import java.util.Date;

import ws.system.model.paciente.DadosContatoPacienteModel;
import ws.system.model.paciente.DadosEnderecoPacienteModel;
import ws.system.model.paciente.DadosPessoaisPacienteModel;

public class PacienteDTO 
{
	private int id;
	private String nome;
	private String sexo;
	private Date dataDeNascimento;
	private String cpf;
	private String rg;
	private String orgaoExpedidor;
	private String cartaoNacionalDeSaude;
	private String observacaoSobreOPaciente;
	private String foto;
	private DadosPessoaisPacienteModel dadosPessoaisPaciente;
	private DadosContatoPacienteModel dadosContatoPaciente;
	private DadosEnderecoPacienteModel dadosEnderecoPaciente;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getSexo() 
	{
		return sexo;
	}
	
	public void setSexo(String sexo) 
	{
		this.sexo = sexo;
	}
	
	public Date getDataDeNascimento() 
	{
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) 
	{
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getCpf() 
	{
		return cpf;
	}
	
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	
	public String getRg() 
	{
		return rg;
	}
	
	public void setRg(String rg) 
	{
		this.rg = rg;
	}
	
	public String getOrgaoExpedidor() 
	{
		return orgaoExpedidor;
	}
	
	public void setOrgaoExpedidor(String orgaoExpedidor) 
	{
		this.orgaoExpedidor = orgaoExpedidor;
	}
	
	public String getCartaoNacionalDeSaude() 
	{
		return cartaoNacionalDeSaude;
	}
	
	public void setCartaoNacionalDeSaude(String cartaoNacionalDeSaude) 
	{
		this.cartaoNacionalDeSaude = cartaoNacionalDeSaude;
	}
	
	public String getObservacaoSobreOPaciente() 
	{
		return observacaoSobreOPaciente;
	}
	
	public void setObservacaoSobreOPaciente(String observacaoSobreOPaciente) 
	{
		this.observacaoSobreOPaciente = observacaoSobreOPaciente;
	}
	
	public String getFoto() 
	{
		return foto;
	}
	
	public void setFoto(String foto) 
	{
		this.foto = foto;
	}
	
	public DadosPessoaisPacienteModel getDadosPessoaisPaciente() 
	{
		return dadosPessoaisPaciente;
	}
	
	public void setDadosPessoaisPaciente(DadosPessoaisPacienteModel dadosPessoaisPaciente) 
	{
		this.dadosPessoaisPaciente = dadosPessoaisPaciente;
	}
	
	public DadosContatoPacienteModel getDadosContatoPaciente() 
	{
		return dadosContatoPaciente;
	}
	
	public void setDadosContatoPaciente(DadosContatoPacienteModel dadosContatoPaciente) 
	{
		this.dadosContatoPaciente = dadosContatoPaciente;
	}
	
	public DadosEnderecoPacienteModel getDadosEnderecoPaciente() 
	{
		return dadosEnderecoPaciente;
	}
	
	public void setDadosEnderecoPaciente(DadosEnderecoPacienteModel dadosEnderecoPaciente) 
	{
		this.dadosEnderecoPaciente = dadosEnderecoPaciente;
	}
}
