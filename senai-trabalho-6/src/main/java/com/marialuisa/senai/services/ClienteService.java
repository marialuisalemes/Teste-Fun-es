package com.marialuisa.senai.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marialuisa.senai.domain.Cliente;
import com.marialuisa.senai.repositories.ClienteRepository;
import com.marialuisa.senai.domain.Cliente;
import com.marialuisa.senai.repositories.ClienteRepository;
import com.marialuisa.senai.services.ClienteService;

import antlr.collections.List;

import com.marialuisa.senai.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private ClienteRepository EnderecoRepository;
	
	
	public Cliente buscar(Integer idCliente) {
		java.util.Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Número de id não encotrado. id: " + idCliente + ", tipo: "
				+ Cliente.class.getName()));
		
	}
	
	public void delete (Integer id) {
		buscar(id);
		repo.deleteById(id);
	}
}