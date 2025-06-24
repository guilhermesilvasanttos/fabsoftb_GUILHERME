import { Component } from '@angular/core';
import { Documento } from '../model/documento';
import { DocumentoService } from '../service/documento.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';



@Component({
  selector: 'app-form-documento',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-documento.component.html',
  styleUrl: './form-documento.component.css',
  providers: [DocumentoService, Router]
})
export class FormDocumentoComponent {
  documento: Documento = new Documento ();

  constructor(
    private documentoService:DocumentoService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){

    const id = this.activeRouter.snapshot.paramMap.get('id');

    if (id){
      this.documentoService.getDocumentoById(id).subscribe(Documento =>{
        this.documento = Documento;
    });
    }


  }

  salvar(){
    this.documentoService.saveDocumento(this.documento)
      .subscribe(resultado => {
        this.router.navigate(['documento']); 
      })
  }

}
