package ws.system.model.paciente;

import javax.persistence.*;

@Entity(name = "dados_pessoais_paciente")
public class DadosPessoaisPacienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String profissao;

	@Column
	private String religiao;

	@Column
	private String naturalidade;

	@Column
	private String escolaridade;

	@Column
	private String nacionalidade;

	@Column(name = "cor")
	private String corDaPeleOuRaca;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "nome_pai")
	private String nomeDopai;

	@Column(name = "nome_mae")
	private String nomeDaMae;

	@Column(name = "quantidade_filhos")
	private String quantidadeDeFilhos;

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCorDaPeleOuRaca() {
		return corDaPeleOuRaca;
	}

	public void setCorDaPeleOuRaca(String corDaPeleOuRaca) {
		this.corDaPeleOuRaca = corDaPeleOuRaca;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNomeDopai() {
		return nomeDopai;
	}

	public void setNomeDopai(String nomeDopai) {
		this.nomeDopai = nomeDopai;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getQuantidadeDeFilhos() {
		return quantidadeDeFilhos;
	}

	public void setQuantidadeDeFilhos(String quantidadeDeFilhos) {
		this.quantidadeDeFilhos = quantidadeDeFilhos;
	}
}
