package edu.douglaslima.contaBancaria.model;

public class ContaCorrente extends ContaBancaria {

	public ContaCorrente(Cliente titular) {
		super(titular);
		this.tipoConta = CONTA_CORRENTE;
	}

}
