package edu.douglaslima.contaBancaria.model;

import java.util.Objects;

public abstract class ContaBancaria {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1000;

	public static final String CONTA_CORRENTE = "Conta Corrente";
	public static final String CONTA_POUPANCA = "Conta Poupanca";

	private int agencia;
	private int numero;
	private double saldo;
	protected String tipoConta;
	private Cliente titular;
	private Extrato extrato;

	public ContaBancaria(Cliente titular) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = ++SEQUENCIAL;
		this.saldo = 0d;
		this.titular = titular;
	}

	public boolean depositar(double valorDeposito) {
		if (valorDeposito <= 0d) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo += valorDeposito;
			this.extrato.registrarDeposito(saldoInicial, saldoInicial);
			return true;
		}
	}

	public boolean sacar(double valorSaque) {
		if (valorSaque > this.saldo) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo -= valorSaque;
			this.extrato.registrarSaque(saldoInicial, saldoInicial);
			return true;
		}
	}

	public boolean transferir(double valorTransferencia, ContaBancaria contaDestino) {
		if (valorTransferencia > this.saldo) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo -= valorTransferencia;
			contaDestino.receber(valorTransferencia, this);
			this.extrato.registrarTransferencia(contaDestino, saldoInicial, saldoInicial);
			return true;
		}
	}
	
	public boolean receber(double valor, ContaBancaria contaOrigem) {
		if (valor <= 0) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo += valor;
			this.extrato.registrarRecebimento(contaOrigem, saldoInicial, saldoInicial);
			return true;
		}
	}
	
	public void imprimirExtratoCompleto() {
		this.extrato.obterExtratoCompleto().forEach(System.out::println);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.agencia, this.numero);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ContaBancaria)) {
			return false;
		}
		ContaBancaria cb = (ContaBancaria) o;
		return this.agencia == cb.getAgencia() && this.numero == cb.getNumero();
	}

	public int getAgencia() {
		return this.agencia;
	}

	public int getNumero() {
		return this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public String getTipoConta() {
		return this.tipoConta;
	}
	
}
