package com.example.finvision.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finvision.model.Finance;
import com.example.finvision.service.FinanceService;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/finance")
public class FinanceController {
	
	private FinanceService financeService;
	
	public FinanceController(FinanceService userService) {
		this.financeService = userService;
	}
	

	@GetMapping
	public ResponseEntity<List<Finance>> listarFinanca(){
		return ResponseEntity.status(200).body(financeService.listarFinancas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Finance> preencherFinanca(@PathVariable Integer id) {
	    Optional<Finance> financa = financeService.preencherFinanca(id);
	    return financa.map(ResponseEntity::ok)
	                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Finance> criarFinanca (@RequestBody Finance finance) {
		return ResponseEntity.status(201).body(financeService.criarFinanca(finance));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Finance> editarFinanca(@PathVariable Integer id, @RequestBody Finance finance) {
	    Optional<Finance> financeExistente = financeService.buscarPorId(id);
	    if (financeExistente.isPresent()) {
	        Finance financaAtualizada = financeService.editarFinanca(id, finance);
	        return ResponseEntity.ok(financaAtualizada);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirFinanca (@PathVariable Integer id){
		financeService.excluirFinanca(id);
		return ResponseEntity.status(204).build();
	}
}	
