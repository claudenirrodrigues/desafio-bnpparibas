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
import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual.MovimentoManualId;
import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif;
import com.bnpparibas.movimentosmanuais.domain.service.MovimentoManualService;
import com.bnpparibas.movimentosmanuais.domain.service.ProdutoCosifService;
import com.bnpparibas.movimentosmanuais.domain.service.ProdutoService;

@RestController
@RequestMapping("/movimentosManuais")
public class MovimentoManualController {
	
	@Autowired
	MovimentoManualService movimentoManualService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ProdutoCosifService produtoCosifService;
	
	
	@GetMapping
	public List<MovimentoManual> findAll() {
		return movimentoManualService.findAll();
	}
	
	@GetMapping("/movimentoManual")
	public ResponseEntity<MovimentoManual> findByMovimentoManualId(@Valid @RequestBody MovimentoManualId movimentoManualId) {
		
		Optional<MovimentoManual> movimentoManual = movimentoManualService.findById(movimentoManualId);
		
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
	
	@PutMapping()
	public ResponseEntity<MovimentoManual> update(@RequestBody MovimentoManual movimentoManual){
		
		if(!movimentoManualService.existsById(movimentoManual.getId())) {
			return ResponseEntity.notFound().build();
		}
		
		movimentoManual = movimentoManualService.save(movimentoManual);
		
		return ResponseEntity.ok(movimentoManual);
	}
	
	@DeleteMapping()
	public ResponseEntity<Void> delete(@RequestBody MovimentoManual movimentoManual){
		
		if(!movimentoManualService.existsById(movimentoManual.getId())) {
			return ResponseEntity.notFound().build();
		}
		
		movimentoManualService.delete(movimentoManual.getId());
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/produtos")
	public List<Produto> findAllProdutos() {
		return produtoService.findAll();
	}
	
	@GetMapping("/produtosCosif")
	public List<ProdutoCosif> findAllProdutosCosif() {
		return produtoCosifService.findAll();
	}
	
	@GetMapping("/produtosCosif/{codigoProduto}")
	public List<ProdutoCosif> findByCodigoProduto(@PathVariable String codigoProduto) {
		Produto produto = new Produto();
		produto.setCodigoProduto(codigoProduto);	
		return produtoCosifService.findByProdutoCosifIdProduto(produto);
			
	}

}
