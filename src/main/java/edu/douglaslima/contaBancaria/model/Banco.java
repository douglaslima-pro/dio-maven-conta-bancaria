package edu.douglaslima.contaBancaria.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Banco implements Comparable<Banco> {

	private int codigo;
	private String nomeSocial;
	private String nome;
	private String cnpj;
	private Map<ContaBancariaID, ContaBancaria> contasGerenciadas = new LinkedHashMap<>();

	public Banco(int codigo, String nomeSocial, String nome, String cnpj) {
		this.codigo = codigo;
		this.nomeSocial = nomeSocial;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public boolean cadastrarContaBancaria(String tipoConta, Cliente titular) {
		ContaBancaria conta;
		if (tipoConta.equalsIgnoreCase(ContaBancaria.CONTA_POUPANCA)) {
			conta = new ContaPoupanca(titular);
			this.contasGerenciadas.put(new ContaBancariaID(conta.getAgencia(), conta.getNumero()), conta);
			return true;
		} else if (tipoConta.equalsIgnoreCase(ContaBancaria.CONTA_CORRENTE)) {
			conta = new ContaCorrente(titular);
			this.contasGerenciadas.put(new ContaBancariaID(conta.getAgencia(), conta.getNumero()), conta);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean excluirContaBancaria(int agencia, int numero) {
		if (this.contasGerenciadas.remove(new ContaBancariaID(agencia, numero)) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ContaBancaria pesquisarContaBancaria(int agencia, int numero) {
		return this.contasGerenciadas.get(new ContaBancariaID(agencia, numero));
	}
	
	public Collection<ContaBancaria> pesquisarContas() {
		return this.contasGerenciadas
				.values();
	}

	@Override
	public int compareTo(Banco b) {
		return this.nomeSocial.compareToIgnoreCase(b.getNomeSocial());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.cnpj);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Banco)) {
			return false;
		}
		Banco b = (Banco) o;
		return this.cnpj.equals(b.getCnpj());
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Map<ContaBancariaID, ContaBancaria> getContasGerenciadas() {
		return contasGerenciadas;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}

class ContaBancariaID implements Comparable<ContaBancariaID> {

	private int agencia;
	private int numero;

	public ContaBancariaID(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
	}

	@Override
	public int compareTo(ContaBancariaID c) {
		int comparaAgencia = Integer.compare(this.agencia, c.getAgencia());
		if (comparaAgencia != 0) {
			return comparaAgencia;
		} else {
			return Integer.compare(this.numero, c.getNumero());
		}
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
		if (!(o instanceof ContaBancariaID)) {
			return false;
		}
		ContaBancariaID c = (ContaBancariaID) o;
		return this.agencia == c.getAgencia() && this.numero == c.getNumero();
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

}
