import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { EMPTY, Observable } from "rxjs";
import { MovimentoManual } from 'src/app/shared/models/movimento-manual.model';
import { AppConfigurationService } from './app-configuration.service';

@Injectable({
  providedIn: 'root'
})
export class MovimentoManualService {

  constructor(private http: HttpClient, private appConfig: AppConfigurationService) { }

  findAll(): Observable<MovimentoManual[]>  {
    return this.http.get<MovimentoManual[]>(this.appConfig.baseUrl + "/movimentosManuais");
  }

  save(data:MovimentoManual): Observable<MovimentoManual>  {
    console.log(data);
    const headers = new HttpHeaders().append('Content-Type', 'application/json');
    
    return this.http.post<MovimentoManual>(this.appConfig.baseUrl + "/movimentosManuais", JSON.stringify(data), { headers } );
  }
  

}
