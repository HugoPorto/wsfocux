package ws.system.model.paciente;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "paciente")
public class PacienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;

	@Column
	private String sexo;

	@Column(name = "data_nascimento")
	private Date dataDeNascimento;

	@Column
	private String cpf;

	@Column
	private String rg;

	@Column(name = "orgao_expedidor")
	private String orgaoExpedidor;

	@Column(name = "cartao_nacional_saude")
	private String cartaoNacionalDeSaude;

	@Column(name = "observacao_sobre_o_paciente")
	private String observacaoSobreOPaciente;

	@Column(name = "foto")
	private String foto;
	
	@OneToOne
	@JoinColumn(name ="id_dados_pessoais_paciente")
	private DadosPessoaisPacienteModel dadosPessoaisPaciente;
	
	@OneToOne
	@JoinColumn(name = "id_dados_contato_paciente")
	private DadosContatoPacienteModel dadosContatoPaciente;
	
	@OneToOne
	@JoinColumn(name = "id_dados_endereco_paciente")
	private DadosEnderecoPacienteModel dadosEnderecoPaciente;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}
	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}
	public String getCartaoNacionalDeSaude() {
		return cartaoNacionalDeSaude;
	}
	public void setCartaoNacionalDeSaude(String cartaoNacionalDeSaude) {
		this.cartaoNacionalDeSaude = cartaoNacionalDeSaude;
	}
	public String getObservacaoSobreOPaciente() {
		return observacaoSobreOPaciente;
	}
	public void setObservacaoSobreOPaciente(String observacaoSobreOPaciente) {
		this.observacaoSobreOPaciente = observacaoSobreOPaciente;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public DadosPessoaisPacienteModel getDadosPessoaisPaciente() {
		return dadosPessoaisPaciente;
	}
	public void setDadosPessoaisPaciente(DadosPessoaisPacienteModel dadosPessoaisPaciente) {
		this.dadosPessoaisPaciente = dadosPessoaisPaciente;
	}
	public DadosContatoPacienteModel getDadosContatoPaciente() {
		return dadosContatoPaciente;
	}
	public void setDadosContatoPaciente(DadosContatoPacienteModel dadosContatoPaciente) {
		this.dadosContatoPaciente = dadosContatoPaciente;
	}
	public DadosEnderecoPacienteModel getDadosEnderecoPaciente() {
		return dadosEnderecoPaciente;
	}
	public void setDadosEnderecoPaciente(DadosEnderecoPacienteModel dadosEnderecoPaciente) {
		this.dadosEnderecoPaciente = dadosEnderecoPaciente;
	}
}
