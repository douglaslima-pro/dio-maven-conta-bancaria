package edu.douglaslima.contaBancaria.model;

import java.util.Objects;

public class Telefone implements Comparable<Telefone> {

	public static final String RESIDENCIAL = "Residencial";
	public static final String COMERCIAL = "Comercial";
	public static final String TRABALHO = "Trabalho";

	private String quemAtende;
	private String numero;
	private String tipo;

	public Telefone(String quemAtende, String numero, String tipo) {
		this.quemAtende = quemAtende;
		this.numero = numero;
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Telefone t) {
		return this.numero.compareToIgnoreCase(t.getNumero());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.numero);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Telefone)) {
			return false;
		}
		Telefone t = (Telefone) o;
		return this.numero.equalsIgnoreCase(t.getNumero());
	}

	public String getQuemAtende() {
		return quemAtende;
	}

	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setQuemAtende(String quemAtende) {
		this.quemAtende = quemAtende;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
