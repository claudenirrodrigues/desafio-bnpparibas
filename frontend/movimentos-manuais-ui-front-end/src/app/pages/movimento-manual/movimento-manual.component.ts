import { Component, OnInit } from '@angular/core';
import { MovimentoManual } from 'src/app/shared/models/movimento-manual.model';
import { MovimentoManualService } from 'src/app/core/services/movimento-manual.service';

@Component({
  selector: 'app-movimento-manual',
  templateUrl: './movimento-manual.component.html',
  styleUrls: ['./movimento-manual.component.css']
})
export class MovimentoManualComponent implements OnInit {

  movimentosManuais: MovimentoManual[] = [];
  movimentoManual: MovimentoManual = new MovimentoManual();


  constructor(public movimentoManualService: MovimentoManualService) { }

  ngOnInit(): void {
    this.findAll();
  }
  
  findAll() {
    this.movimentoManualService.findAll().subscribe((data: MovimentoManual[]) => {
      if (JSON.stringify(data['data']) != 'null' && JSON.stringify(data) != '{}' && JSON.stringify(data) != '[]' && typeof JSON.stringify(data) != 'undefined') {
          this.movimentosManuais = data['data'];
          //this.dataSource = new MatTableDataSource(this.lstMovimento);
          //this.dataSource.paginator = this.paginator;
      }
    });
  }

  create(){
    this.movimentoManualService.save(this.movimentoManual).subscribe(data => {
      if (JSON.stringify(data['data']) != 'null' && JSON.stringify(data) != '{}' && JSON.stringify(data) != '[]' && typeof JSON.stringify(data) != 'undefined') {
          console.log(data);
      }
    });
  }

}
