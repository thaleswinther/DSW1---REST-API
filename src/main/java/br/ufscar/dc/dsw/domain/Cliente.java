package br.ufscar.dc.dsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCPF;


@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

	@UniqueCPF (message = "{Unique.cliente.CPF}")
	@NotBlank(message = "{NotBlank.cliente.cpf}")
	@Size(min = 14, max = 14, message = "{Size.cliente.CPF}")
	@Column(nullable = false, length = 60, unique = true)
	private String CPF;

	@NotBlank(message = "{NotBlank.cliente.telefone}")
	@Size(min = 15, max = 15,  message = "{Size.telefone.CPF}")
	@Column(nullable = false, length = 60)
	private String telefone;
    
	@NotNull(message = "{NotNull.cliente.sexo}")
	@Column(nullable = false, length = 20)
	private String sexo;
	
	@NotNull(message = "{NotNull.cliente.dataNascimento}")
	@Column(nullable = false, length = 30)
	private String dataNascimento;
	//private LocalDate dataNascimento;
    
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	private List<Locacao> locacoes;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		this.CPF= cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

}