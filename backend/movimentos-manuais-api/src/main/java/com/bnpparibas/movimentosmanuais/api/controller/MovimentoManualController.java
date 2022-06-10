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
import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.service.MovimentoManualService;
import com.bnpparibas.movimentosmanuais.domain.service.ProdutoService;

@RestController
@RequestMapping("/movimentosManuais")
public class MovimentoManualController {
	
	@Autowired
	MovimentoManualService movimentoManualService;
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public List<MovimentoManual> findAll() {
		return movimentoManualService.findAll();
	}
	
	@GetMapping("/{numeroLancamento}")
	public ResponseEntity<MovimentoManual> findByNumeroLancamento(@PathVariable Long numeroLancamento) {
		Optional<MovimentoManual> movimentoManual = movimentoManualService.findByNumeroLancamento(numeroLancamento);
		
		if(movimentoManual.isPresent()) {
			return ResponseEntity.ok(movimentoManual.get());
		}
		return ResponseEntity.notFound().build();	
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public MovimentoManual create(@Valid @RequestBody MovimentoManual movimentoManual) {
		return movimentoManualService.save(movimentoManual);
	}
	
	@PutMapping("/{numeroLancamento}")
	public ResponseEntity<MovimentoManual> update(@Valid @PathVariable Long numeroLancamento, @RequestBody MovimentoManual movimentoManual){
		
		if(!movimentoManualService.existsByNumeroLancamento(numeroLancamento)) {
			return ResponseEntity.notFound().build();
		}
		
		movimentoManual.setNumeroLancamento(numeroLancamento);
		movimentoManual = movimentoManualService.save(movimentoManual);
		
		return ResponseEntity.ok(movimentoManual);
	}
	
	@DeleteMapping("/{numeroLancamento}")
	public ResponseEntity<Void> delete(@PathVariable Long numeroLancamento){
		
		if(!movimentoManualService.existsByNumeroLancamento(numeroLancamento)) {
			return ResponseEntity.notFound().build();
		}
		
		movimentoManualService.delete(numeroLancamento);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/produtos")
	public List<Produto> findAllProdutos() {
		return produtoService.findAll();
	}

}
