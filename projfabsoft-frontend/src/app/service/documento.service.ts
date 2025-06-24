import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Documento } from '../model/documento';

@Injectable({
  providedIn: 'root'
})
export class DocumentoService {
  apiURL = "http://localhost:8080/api/v1/documento";
  
  constructor(private http:HttpClient) { }

  getDocumento(){
    return this.http.get<Documento[]>(this.apiURL);
  }

  saveDocumento(documento:Documento){
    if(documento.id){
      return this.http.put(this.apiURL + '/' + documento.id, documento);
    }
    return this.http.post(this.apiURL,documento);
  }

  getDocumentoById(id: any) {
    return this.http.get<Documento>(this.apiURL + '/' + id);

  }

}
