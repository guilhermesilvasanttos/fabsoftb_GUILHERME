import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Itemavaliacao } from '../model/itemavaliacao';

@Injectable({
  providedIn: 'root'
})
export class ItemavaliacaoService {
  apiURL = "http://localhost:8080/api/v1/itemavaliacao";
  
  constructor(private http:HttpClient) { }

  getItemavaliacao(){
    return this.http.get<Itemavaliacao[]>(this.apiURL);
  }

  saveItemavaliacao(itemavaliacao:Itemavaliacao){
    if(itemavaliacao.id){
      return this.http.put(this.apiURL + '/' + itemavaliacao.id, itemavaliacao);
    }
    return this.http.post(this.apiURL,itemavaliacao);
  }

  getItemavaliacaoById(id: any) {
    return this.http.get<Itemavaliacao>(this.apiURL + '/' + id);

  }

}