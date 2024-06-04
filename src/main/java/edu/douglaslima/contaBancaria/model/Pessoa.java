package edu.douglaslima.contaBancaria.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa implements Comparable<Pessoa> {
	
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String naturalidade;
	private char sexo;
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento, char sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}
	
	@Override
	public int compareTo(Pessoa p) {
		return this.nome.compareToIgnoreCase(p.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.cpf);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Pessoa)) {
			return false;
		}
		Pessoa p = (Pessoa) o;
		return this.cpf.equalsIgnoreCase(p.getCpf());
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
