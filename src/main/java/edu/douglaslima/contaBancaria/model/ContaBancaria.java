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
		this.extrato = new Extrato();
	}

	public boolean depositar(double valorDeposito) {
		if (valorDeposito <= 0d) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo += valorDeposito;
			this.extrato.registrarDeposito(saldoInicial, this.saldo);
			return true;
		}
	}

	public boolean sacar(double valorSaque) {
		if (valorSaque > this.saldo) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo -= valorSaque;
			this.extrato.registrarSaque(saldoInicial, this.saldo);
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
			this.extrato.registrarTransferencia(contaDestino, saldoInicial, this.saldo);
			return true;
		}
	}

	public boolean receber(double valor, ContaBancaria contaOrigem) {
		if (valor <= 0) {
			return false;
		} else {
			double saldoInicial = this.saldo;
			this.saldo += valor;
			this.extrato.registrarRecebimento(contaOrigem, saldoInicial, this.saldo);
			return true;
		}
	}

	public void imprimirExtratoCompleto() {
		System.out.println();
		System.out.println("Cliente: " + this.titular.getNome());
		System.out.println("CPF: " + this.titular.getCpf());
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

	@Override
	public String toString() {
		return String.format("ContaBancaria [titular = '%s', agencia = %d, numero = %d, tipoConta = '%s', saldo = %.2f]",
				this.titular.getNome(), this.agencia, this.numero, this.tipoConta, this.saldo);
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
