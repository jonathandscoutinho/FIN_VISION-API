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
	
	private FinanceService userService;
	
	public FinanceController(FinanceService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<Finance>> listaUsuarios(){
		return ResponseEntity.status(200).body(userService.listarUsuario());
	}
	
	@PostMapping
	public ResponseEntity<Finance> criarUsuario (@RequestBody Finance user) {
		return ResponseEntity.status(201).body(userService.criarUsuario(user));
	}
	
	@PutMapping
	public ResponseEntity<Finance> editarUsuario (@RequestBody Finance user) {
		return ResponseEntity.status(201).body(userService.editarUsuario(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirUsuario (@PathVariable Integer id){
		userService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}
}	
