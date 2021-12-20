package com.marialuisa.senai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marialuisa.senai.domain.Cliente;
import com.marialuisa.senai.domain.Estado;
import com.marialuisa.senai.domain.enums.TipoCliente;
import com.marialuisa.senai.repositories.ClienteRepository;
import com.marialuisa.senai.repositories.EstadoRepository;
@SpringBootApplication
public class SenaiTrabalho6Application implements CommandLineRunner { 

	@Autowired
    private EstadoRepository estadoRepository; 
	@Autowired 
	private ClienteRepository clienteRepository; 
	public static void main(String[] args) {
		SpringApplication.run(SenaiTrabalho6Application.class, args); 
	} 
	@Override
	public void run(String... args ) throws Exception {
		Estado est1 = new Estado(null ,"Minas Gerais", null); 
		Estado est2 = new Estado(null ,"São Paulo", null);
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
	
	Cliente cli = new Cliente(null, "Maria Luísa Lemes", "46456356835", "malu@yahoo.com.br" , TipoCliente.PESSOAFISICA );
	cli.getTelefones().addAll(Arrays.asList("45453434", "8867867867" ));
	clienteRepository.saveAll(Arrays.asList(cli));
	}
	}