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
	public List<Finance> listarFinancas(){
		List<Finance> Lista = (List<Finance>) repository.findAll();
		return Lista;
	}
	
	//POST
	public Finance criarFinanca(Finance financa) {
		Finance financaNova = repository.save(financa);
		return financaNova;
	}
	
	//PUT
	public Finance editarFinanca(Finance financa) {
		Finance financaNova = repository.save(financa);
		return financaNova;
	}
	
	//DELETE
	public Boolean excluirFinanca(Integer id) {
		repository.deleteById(id);
		return true;
	}
		
}