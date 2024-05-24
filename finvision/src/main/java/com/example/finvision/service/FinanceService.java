package com.example.finvision.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.finvision.model.Finance;
import com.example.finvision.repository.IFinance;

@Service
public class FinanceService {

	//instanciação do CRUD Repository
	private IFinance repository;
	
	//Construtor do objeto repository acima
	public  FinanceService(IFinance repository) {
		this.repository = repository;
	}
	
	//GET
	public List<Finance> listarUsuario(){
		List<Finance> Lista = (List<Finance>) repository.findAll();
		return Lista;
	}
	
	//POST
	public Finance criarUsuario(Finance user) {
		Finance usuarioNovo = repository.save(user);
		return usuarioNovo;
	}
	
	//PUT
	public Finance editarUsuario(Finance user) {
		Finance usuarioNovo = repository.save(user);
		return usuarioNovo;
	}
	
	//DELETE
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
		
}