package com.marialuisa.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marialuisa.senai.domain.Endereco;
import com.marialuisa.senai.repositories.EnderecoRepository;



@SpringBootTest
public class EnderecoTest {

	@Autowired
	EnderecoRepository enderecoRepo;

	@Test
	void Cliente () {
		Endereco end = new Endereco();
		end.setId(1);
		end.setBairro("Margaridas");
        end.getLogradouro();
        end.setNumero("879");
        end.setComplemento("");
		end.setCep("6788868766");
		enderecoRepo.save(end);
	}


	@Test
	public void ListaEndereco() {
		List<Endereco> list = enderecoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		}

	@Test 
	public void id() {
		Endereco endereco = enderecoRepo.findById(1).get();
		assertEquals("Margaridas", endereco.getBairro());
	}

	@Test
	public void updateEndereco() {
		Endereco endereco = enderecoRepo.findById(1).get();
		endereco.setBairro("Margaridas Brancas");
		enderecoRepo.save(endereco);
		assertNotEquals("Margaridas", endereco.getBairro());
	}


	@Test
	public void deleteEndereco() {
		enderecoRepo.deleteById(2);
		assertThat(enderecoRepo.existsById(2));
	}
	}