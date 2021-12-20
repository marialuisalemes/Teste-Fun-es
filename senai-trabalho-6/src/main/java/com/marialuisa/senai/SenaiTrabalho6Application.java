package com.marialuisa.senai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marialuisa.senai.domain.Cidade;
import com.marialuisa.senai.domain.Cliente;
import com.marialuisa.senai.domain.Endereco;
import com.marialuisa.senai.domain.Estado;
import com.marialuisa.senai.domain.enums.TipoCliente;
import com.marialuisa.senai.repositories.CidadeRepository;
import com.marialuisa.senai.repositories.ClienteRepository;
import com.marialuisa.senai.repositories.EstadoRepository;
@SpringBootApplication
public class SenaiTrabalho6Application implements CommandLineRunner { 

	@Autowired
    private EstadoRepository estadoRepository; 
	@Autowired 
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	@Autowired
	private com.marialuisa.senai.repositories.EnderecoRepository EnderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SenaiTrabalho6Application.class, args); 
	} 
	@Override
	public void run(String... args ) throws Exception {
		Estado est1 = new Estado(null ,"Minas Gerais", null); 
		Estado est2 = new Estado(null ,"São Paulo", null);
		estadoRepository.saveAll(Arrays.asList(est1, est2)); 
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Uberaba", est2);
		cidadeRepository.saveAll(Arrays.asList(c1,c2));
		
	
	Cliente cli = new Cliente(null, "Maria Luísa", "7675645646", "marialuisa@gmail.com" , TipoCliente.PESSOAFISICA );
	cli.getTelefones().addAll(Arrays.asList("535343433", "434543553" ));
	clienteRepository.saveAll(Arrays.asList(cli));
	
	Endereco e1 = new Endereco(null, "Rua Das Flores", "13","", "Jardins", "45234242",cli,c1);
	
	cli.getEnderecos().addAll(Arrays.asList(e1));
	
	EnderecoRepository.saveAll(Arrays.asList(e1));
	}
	public ClienteRepository getClienteRepository() {
		return ClienteRepository;
	}
	public void setClienteRepository(ClienteRepository clienteRepository) {
		ClienteRepository = clienteRepository;
	}
	}