package com.example.finvision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.finvision.model.Finance;
import com.example.finvision.repository.IFinance;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FinanceService {

	private IFinance repository;
	
	public  FinanceService(IFinance repository) {
		this.repository = repository;
	}
	
	//GET
	public List<Finance> listarFinancas(){
		List<Finance> Lista = (List<Finance>) repository.findAll();
		return Lista;
	}
	
	//GET/{id} - Irá retornar um GET apenas com o id solicitado no corpo da requisição.
	public Optional<Finance> preencherFinanca(Integer id) {
	    return repository.findById(id);
	}
	
	//POST
	public Finance criarFinanca(Finance financa) {
		Finance financaNova = repository.save(financa);
		return financaNova;
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
	
	//Verifica se existe este id no banco, deve retornar true para o método editarFinanca no FinanceController
	public Optional<Finance> buscarPorId(Integer id) {
        return repository.findById(id);
    }
	
	//DELETE
	public Boolean excluirFinanca(Integer id) {
		repository.deleteById(id);
		return true;
	}
		
}