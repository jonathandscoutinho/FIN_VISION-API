package com.example.finvision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.finvision.model.Finance;
import com.example.finvision.repository.IFinance;

import jakarta.persistence.EntityNotFoundException;

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
	
	public Optional<Finance> preencherFinanca(Integer id) {
	    return repository.findById(id);
	}
	
	//POST
	public Finance criarFinanca(Finance financa) {
		Finance financaNova = repository.save(financa);
		return financaNova;
	}
	
	//
	public Optional<Finance> buscarPorId(Integer id) {
        return repository.findById(id);
    }
	
	//PUT
	public Finance editarFinanca(Integer id, Finance financa) {
	    if (repository.existsById(id)) {
	        financa.setId(id);  // Define o ID da entidade para garantir que será atualizado
	        return repository.save(financa);
	    } else {
	        throw new EntityNotFoundException("Finance with ID " + id + " not found");
	    }
	}
	
	//DELETE
	public Boolean excluirFinanca(Integer id) {
		repository.deleteById(id);
		return true;
	}
		
}