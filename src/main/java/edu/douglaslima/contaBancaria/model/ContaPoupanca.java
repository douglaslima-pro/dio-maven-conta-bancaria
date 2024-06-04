package edu.douglaslima.contaBancaria.model;

public class ContaPoupanca extends ContaBancaria {

	public ContaPoupanca(Cliente titular) {
		super(titular);
		this.tipoConta = CONTA_POUPANCA;
	}

}
