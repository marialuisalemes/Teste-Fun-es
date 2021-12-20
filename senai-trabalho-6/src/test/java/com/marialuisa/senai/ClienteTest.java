package com.marialuisa.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marialuisa.senai.domain.Cliente;
import com.marialuisa.senai.repositories.ClienteRepository;



@SpringBootTest
public class ClienteTest {

@Autowired
ClienteRepository clienteRepo;

@Test
void Cliente () {
	Cliente cli = new Cliente();
	cli.setIdCliente(null);
	cli.setNome("Maria Luísa");
	cli.setCpfOuCnpj("86786788778");
	cli.setEmail("malu@yahoo.com.br");
	clienteRepo.save(cli);
}


@Test
public void ListaCliente() {
	List<Cliente> list = clienteRepo.findAll();
	assertThat(list).size().isGreaterThan(0);
	}

@Test 
public void idCliente() {
	Cliente cliente = clienteRepo.findById(1).get();
	assertEquals("Bibor", cliente.getNome());
}

@Test
public void updateCliente() {
	Cliente cliente = clienteRepo.findById(1).get();
	cliente.setNome("Bibor Lemes");
	clienteRepo.save(cliente);
	assertNotEquals("Bibor", cliente.getNome());
}


@Test
public void deleteCliente() {
	clienteRepo.deleteById(2);
	assertThat(clienteRepo.existsById(2));
}

@Test
public void somar() {
	double num1 = 8;
	double num2 = 7;
	Cliente cliente = new Cliente();
	double soma = cliente.somar(num1, num2);
	assertEquals(15, soma);
}

@Test
public void subtrair() {
	double num1 = 10;
	double num2 = 9;
	Cliente cliente = new Cliente();
	double subtrair = cliente.subtrair(num1, num2);
	assertEquals(1, subtrair);
}


@Test
public void multiplicar() {
	double num1 = 6;
	double num2 = 10;
	Cliente cliente = new Cliente();
	double multiplicar = cliente.multiplicar(num1, num2);
	assertEquals(60, multiplicar);
}

@Test
public void dividir() {
	double num1 = 60;
	double num2 = 10;
	Cliente cliente = new Cliente();
	double dividir = cliente.dividir(num1, num2);
	assertEquals(6, dividir);
}
}