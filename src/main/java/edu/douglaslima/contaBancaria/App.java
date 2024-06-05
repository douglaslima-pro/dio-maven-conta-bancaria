package edu.douglaslima.contaBancaria;

import edu.douglaslima.contaBancaria.model.*;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class App {
	
	public static void main(String[] args) {

		Cliente douglas = new Cliente("Douglas Souza de Lima", "123.456.789-00", LocalDate.of(2001, 1, 1), 'M',
				"douglaslima-pro@outlook.com");
		Cliente carol = new Cliente("Carol da Silva Oliveira", "001.556.231-98", LocalDate.of(1996, 5, 10), 'F',
				"carol.qualquercoisa@gmail.com");

		Banco itau = new Banco(341, "ITAU UNIBANCO S.A.", "Itaú", "60.701.190/0001-04");
		itau.cadastrarContaBancaria(ContaBancaria.CONTA_CORRENTE, douglas);
		itau.cadastrarContaBancaria(ContaBancaria.CONTA_POUPANCA, carol);
		itau.pesquisarContaBancaria(1, 1001).depositar(1500.0);
		itau.pesquisarContaBancaria(1, 1001).transferir(250.0, itau.pesquisarContaBancaria(1, 1002));
		
		itau.pesquisarContas().forEach(System.out::println);
		
		itau.pesquisarContaBancaria(1, 1001).sacar(100.0);
		itau.pesquisarContaBancaria(1, 1002).transferir(50.0, itau.pesquisarContaBancaria(1, 1001));
		
		itau.pesquisarContaBancaria(1, 1001).imprimirExtratoCompleto();
		itau.pesquisarContaBancaria(1, 1002).imprimirExtratoCompleto();

	}
	
}
