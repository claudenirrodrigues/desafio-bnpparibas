import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { EMPTY, from, Observable } from "rxjs";
import { MovimentoManual } from 'src/app/shared/models/movimento-manual.model';
import { Produto } from 'src/app/shared/models/produto.model';
import { ProdutoCosif } from 'src/app/shared/models/produto-cosif.model';
import { AppConfigurationService } from './app-configuration.service';
import { catchError, retry, map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class MovimentoManualService {

  constructor(private http: HttpClient, private appConfig: AppConfigurationService) { }

  findAll(): Observable<MovimentoManual[]>  {
    return this.http.get<MovimentoManual []>(this.appConfig.baseUrl + "/movimentosManuais").pipe(
      retry(1),
      map((obj)=>obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  findAllProdutos(): Observable<Produto[]>  {
    return this.http.get<Produto []>(this.appConfig.baseUrl + "/movimentosManuais/produtos").pipe(
      retry(1),
      map((obj)=>obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  findAllProdutosCosif(): Observable<ProdutoCosif[]>  {
    return this.http.get<ProdutoCosif []>(this.appConfig.baseUrl + "/movimentosManuais/produtosCosif").pipe(
      retry(1),
      map((obj)=>obj),
      catchError((e) => this.errorHandler(e))
    );
    
  }

  save(data:MovimentoManual): Observable<MovimentoManual>  {
    const headers = new HttpHeaders().append('Content-Type', 'application/json');
    
    return this.http.post<MovimentoManual>(this.appConfig.baseUrl + "/movimentosManuais", JSON.stringify(data), { headers } ).pipe(
      retry(1),
      map((obj) => obj),
      catchError((e) => this.errorHandler(e)));
  }
  
  errorHandler(e: any): Observable<any> {
    console.log(e);
    return EMPTY;
  }  

}
