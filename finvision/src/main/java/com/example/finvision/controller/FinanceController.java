package com.example.finvision.controller;

import java.util.List;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Finance>> listarFinancaId(){
		return ResponseEntity.status(200).body(financeService.listarFinancas());
	}
	
	@GetMapping
	public ResponseEntity<List<Finance>> listarFinanca(){
		return ResponseEntity.status(200).body(financeService.listarFinancas());
	}
	
	@PostMapping
	public ResponseEntity<Finance> criarFinanca (@RequestBody Finance finance) {
		return ResponseEntity.status(201).body(financeService.criarFinanca(finance));
	}
	
	@PutMapping
	public ResponseEntity<Finance> editarFinanca (@RequestBody Finance finance) {
		return ResponseEntity.status(201).body(financeService.editarFinanca(finance));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirFinanca (@PathVariable Integer id){
		financeService.excluirFinanca(id);
		return ResponseEntity.status(204).build();
	}
}	
