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
  templateUrl: './documento.component.html',
  styleUrl: './documento.component.css',
  providers: [ItemavaliacaoService, Router]
})
export class ClienteComponent {
    listaClientes: Documento[] = [];

    constructor(private itemavaliacaoService: ItemavaliacaoService,
      private router:Router
    ){}

    novo(){
      this.router.navigate(['itemavaliacao/novo']);
    }

    ngOnInit(){
      console.log("Carregando Documento");
      this.itemavaliacaoService.getClientes().subscribe(
        Itemavaliacao => {
          this.listaClientes = Itemavaliacao;
        }
      )    
    }

      alterar(cliente:Documento){
        this.router.navigate(['itemavaliacao/alterar', Itemavaliacao.id]);
      }

}