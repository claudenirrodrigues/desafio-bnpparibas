import { Component, OnInit } from '@angular/core';
import { MovimentoManual, UserDefault } from 'src/app/shared/models/movimento-manual.model';
import { Produto } from 'src/app/shared/models/produto.model';
import { ProdutoCosif } from 'src/app/shared/models/produto-cosif.model';
import { MovimentoManualService } from 'src/app/core/services/movimento-manual.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-movimento-manual',
  templateUrl: './movimento-manual.component.html',
  styleUrls: ['./movimento-manual.component.css']
})
export class MovimentoManualComponent implements OnInit {

  movimentosManuais: MovimentoManual[] = new Array();
  produtos: Produto[] = new Array();
  produtosCosif: ProdutoCosif[] = new Array();
  movimentoManual: MovimentoManual = new MovimentoManual();
  

  
  componentsDisabled = true;



  constructor(public movimentoManualService: MovimentoManualService) { }

  ngOnInit(): void {
    this.loadView();    
  }
  
  loadView() {
    this.movimentoManual.produtoCosif = new ProdutoCosif();
    this.movimentoManual.produtoCosif.produto = new Produto();
    this.findAll();
    this.findAllprodutos();
    this.findAllProdutosCosif();
  }
  
  findAllProdutosCosif() {
    this.movimentoManualService.findAllProdutosCosif().subscribe(data => {
      if (JSON.stringify(data['data']) != 'null' && JSON.stringify(data) != '{}' && JSON.stringify(data) != '[]' && typeof JSON.stringify(data) != 'undefined') {
          this.produtosCosif = data;
          console.log(this.produtosCosif);
      }
    });
  }
  
  findAllprodutos() {
    this.movimentoManualService.findAllProdutos().subscribe((data: Produto[]) => {
      if (JSON.stringify(data['data']) != 'null' && JSON.stringify(data) != '{}' && JSON.stringify(data) != '[]' && typeof JSON.stringify(data) != 'undefined') {
          this.produtos = data;
          console.log(this.produtos);
      }
    });
  }
  
  findAll() {
    this.movimentoManualService.findAll().subscribe((data: MovimentoManual[]) => {
      if (JSON.stringify(data['data']) != 'null' && JSON.stringify(data) != '{}' && JSON.stringify(data) != '[]' && typeof JSON.stringify(data) != 'undefined') {
          this.movimentosManuais = data;
          console.log(this.movimentosManuais);
      }
    });
  }

  create(form: NgForm){
    
    this.setValuesDefault();
    
    this.movimentoManualService.save(this.movimentoManual).subscribe(data => {
      if (JSON.stringify(data['data']) != 'null' && JSON.stringify(data) != '{}' && JSON.stringify(data) != '[]' && typeof JSON.stringify(data) != 'undefined') {
          console.log(data);
          this.clearForm(form);
          this.loadView();
      }
    });
  }

  setValuesDefault() {
    this.movimentoManual.codigoUsuario = UserDefault.USUARIO_TESTE;
    this.movimentoManual.dataMovimento = new Date();
  }

  clearForm(form: NgForm) {
    form.resetForm();
    this.componentsDisabled = true;
  }

}

