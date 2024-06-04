package edu.douglaslima.contaBancaria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Movimentacao implements Comparable<Movimentacao> {
	
	public static final String DEPOSITO = "Deposito";
	public static final String SAQUE = "Saque";
	public static final String TRANSFERENCIA = "Transferencia";
	public static final String RECEBIMENTO = "Recebimento";
	
	private String tipo;
	private LocalDate data;
	private LocalTime hora;
	private double saldoInicial;
	private double saldoFinal;
	private ContaBancaria contaDestino;
	private ContaBancaria contaOrigem;
	
	public Movimentacao(String tipo, LocalDate data, LocalTime hora, double saldoInicial, double saldoFinal) {
		this.tipo = tipo;
		this.data = data;
		this.hora = hora;
		this.saldoInicial = saldoInicial;
		this.saldoFinal = saldoFinal;
	}
	
	@Override
	public int compareTo(Movimentacao m) {
		int compararData = this.data.compareTo(m.getData());
		if (compararData != 0) {
			return compararData;
		} else {
			return this.hora.compareTo(m.getHora());
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.data, this.hora);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Movimentacao)) {
			return false;
		}
		Movimentacao m = (Movimentacao) o;
		return this.data.equals(m.getData()) && this.hora.equals(m.getHora());
	}
	
	@Override
	public String toString() {
		return String.format("Movimentacao [tipo = '%s', data = %s, hora = %s, saldoInicial = %,.2f, saldoFinal = %,.2f]", this.tipo, this.data.toString(), this.hora.toString(), this.saldoInicial, this.saldoFinal);
	}

	public String getTipo() {
		return this.tipo;
	}

	public LocalDate getData() {
		return this.data;
	}

	public LocalTime getHora() {
		return this.hora;
	}

	public double getSaldoInicial() {
		return this.saldoInicial;
	}

	public double getSaldoFinal() {
		return this.saldoFinal;
	}

	public ContaBancaria getContaDestino() {
		return this.contaDestino;
	}

	public ContaBancaria getContaOrigem() {
		return this.contaOrigem;
	}

	public void setContaDestino(ContaBancaria contaDestino) {
		this.contaDestino = contaDestino;
	}

	public void setContaOrigem(ContaBancaria contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

}
