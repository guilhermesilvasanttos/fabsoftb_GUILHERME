import { Component } from '@angular/core';
import { Documento } from '../model/documento';
import { ItemavaliacaoService}from '../service/itemavaliacao.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'
import { Itemavaliacao } from '../model/itemavaliacao';

@Component({
  selector: 'app-documento',
  imports: [HttpClientModule, CommonModule,],
  templateUrl: './itemavaliacao.component.html',
  styleUrl: './itemavaliacao.component.css',
  providers: [ItemavaliacaoService, Router]
})
export class ItemavaliacaoComponent {
    listaItemavaliacao: Itemavaliacao[] = [];

    constructor(private ItemavaliacaoService: ItemavaliacaoService,
      private router:Router
    ){}

    novo(){
      this.router.navigate(['itemavaliacao/novo']);
    }

    ngOnInit(){
      console.log("Carregando Avaliação");
      this.ItemavaliacaoService.getItemavaliacao().subscribe(
        Itemavaliacao => {
          this.listaItemavaliacao = Itemavaliacao;
        }
      )    
    }

      alterar(itemavaliacao:Itemavaliacao){
        this.router.navigate(['itemavaliacao/alterar', itemavaliacao.id]);
      }

}