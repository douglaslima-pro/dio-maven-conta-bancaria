package edu.douglaslima.contaBancaria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Extrato {

	private Set<Movimentacao> historicoMovimentacoes = new LinkedHashSet<>();

	public boolean registrarDeposito(double saldoInicial, double saldoFinal) {
		try {
			Thread.sleep(1000);
			Movimentacao movimentacao = new Movimentacao(Movimentacao.DEPOSITO, LocalDate.now(), LocalTime.now(),
					saldoInicial, saldoFinal);
			return this.historicoMovimentacoes.add(movimentacao);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean registrarSaque(double saldoInicial, double saldoFinal) {
		try {
			Thread.sleep(1000);
			Movimentacao movimentacao = new Movimentacao(Movimentacao.SAQUE, LocalDate.now(), LocalTime.now(),
					saldoInicial, saldoFinal);
			return this.historicoMovimentacoes.add(movimentacao);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean registrarTransferencia(ContaBancaria contaDestino, double saldoInicial, double saldoFinal) {
		try {
			Thread.sleep(1000);
			Movimentacao movimentacao = new Movimentacao(Movimentacao.TRANSFERENCIA, LocalDate.now(), LocalTime.now(),
					saldoInicial, saldoFinal);
			movimentacao.setContaDestino(contaDestino);
			return this.historicoMovimentacoes.add(movimentacao);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean registrarRecebimento(ContaBancaria contaOrigem, double saldoInicial, double saldoFinal) {
		try {
			Thread.sleep(1000);
			Movimentacao movimentacao = new Movimentacao(Movimentacao.RECEBIMENTO, LocalDate.now(), LocalTime.now(),
					saldoInicial, saldoFinal);
			movimentacao.setContaDestino(contaOrigem);
			return this.historicoMovimentacoes.add(movimentacao);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Set<Movimentacao> obterExtratoCompleto() {
		return this.historicoMovimentacoes;
	}

}
