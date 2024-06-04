package edu.douglaslima.contaBancaria.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Cliente extends Pessoa {

	private String email;
	private Set<Telefone> telefones = new LinkedHashSet<>();
	private Endereco residencia;
	private Endereco trabalho;
	
	public Cliente(String nome, String cpf, LocalDate dataNascimento, char sexo, String email) {
		super(nome, cpf, dataNascimento, sexo);
		this.email = email;
	}
	
	public boolean registrarTelefone(String quemAtende, String numero, String tipo) {
		String atende;
		if (quemAtende.equalsIgnoreCase(null) || quemAtende.equalsIgnoreCase("")) {
			atende = super.getNome();
		} else {
			atende = quemAtende;
		}
		return this.telefones.add(new Telefone(atende, numero, tipo));
	}
	
	public boolean removerTelefone(String numero) {
		Optional<Telefone> telefoneRemovido = this.telefones
				.stream()
				.filter(telefone -> telefone.getNumero().equals(numero))
				.findFirst();
		if (telefoneRemovido.isPresent()) {
			return this.telefones.remove(telefoneRemovido.get());
		} else {
			return false;
		}
	}

	public void registrarResidencia(String estado, String cidade, String logradouro, String cep, int numero, String complemento) {
		this.residencia = new Endereco(estado, cidade, logradouro, cep);
	}

	public void registrarTrabalho(String estado, String cidade, String logradouro, String cep, int numero, String complemento) {
		this.residencia = new Endereco(estado, cidade, logradouro, cep);
	}
	
	public Set<Telefone> getTelefones() {
		return this.telefones;
	}
	
	public String getEmail() {
		return email;
	}

	public Endereco getResidencia() {
		return residencia;
	}

	public Endereco getTrabalho() {
		return trabalho;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
