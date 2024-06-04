package edu.douglaslima.contaBancaria.model;

public class Endereco {

	private String estado;
	private String cidade;
	private String logradouro;
	private int numero;
	private String complemento;
	private String cep;
	
	public Endereco(String estado, String cidade, String logradouro, String cep) {
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
