package com.bnpparibas.movimentosmanuais.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.repository.MovimentoManualRepository;
import com.bnpparibas.movimentosmanuais.domain.service.MovimentoManualService;

@RestController
@RequestMapping("/movimentosManuais")
public class MovimentoManualController {
	
	@Autowired
	MovimentoManualService movimentoManualService;
	
	@Autowired
	MovimentoManualRepository movimentoManualRepository;
	
	@GetMapping
	public List<MovimentoManual> listar() {
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovimentoManual> buscar(@PathVariable Integer id) {
		Optional<MovimentoManual> movimentoManual = movimentoManualRepository.findById(id);
		
		if(movimentoManual.isPresent()) {
			return ResponseEntity.ok(movimentoManual.get());
		}
		return ResponseEntity.notFound().build();	
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public MovimentoManual adicionar(@Valid @RequestBody MovimentoManual movimentoManual) {
		return movimentoManualService.salvar(movimentoManual);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovimentoManual> atualizar(@Valid @PathVariable Integer id, @RequestBody MovimentoManual movimentoManual){
		
		if(!movimentoManualRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		movimentoManual.setAno(id);
		movimentoManual = movimentoManualService.salvar(movimentoManual);
		
		return ResponseEntity.ok(movimentoManual);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id){
		
		if(!movimentoManualRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		movimentoManualService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
