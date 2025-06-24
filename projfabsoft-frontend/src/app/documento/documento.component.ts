import { Component } from '@angular/core';
import { Documento } from '../model/documento';
import { DocumentoService }from '../service/documento.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'

@Component({
  selector: 'app-documento',
  imports: [HttpClientModule, CommonModule,],
  templateUrl: './documento.component.html',
  styleUrl: './documento.component.css',
  providers: [DocumentoService, Router]
})
export class DocumentoComponent {
    listaClientes: Documento[] = [];

    constructor(private documentoService: DocumentoService,
      private router:Router
    ){}

    novo(){
      this.router.navigate(['clientes/novo']);
    }

    ngOnInit(){
      console.log("Carregando Documento");
      this.documentoService.getDocumento().subscribe(
        Documento => {
          this.listaDocumento = documento;
        }
      )    
    }

      alterar(cliente:Documento){
        this.router.navigate(['documento/alterar', Documento.id]);
      }

}
