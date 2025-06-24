import { Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';
import { DocumentoComponent } from './documento/documento.component';
import { FormDocumentoComponent } from './form-documento/form-documento.component';
import { Component } from '@angular/core';

export const routes: Routes = [
    {path: 'clientes', component: ClienteComponent},
    {path: 'clientes/novo', component: FormClienteComponent},
    {path: 'clientes/alterar/:id', component: FormClienteComponent},
    {path: 'documento/alterar/:id', component: FormDocumentoComponent},
    {path: 'documento', component: DocumentoComponent},
    {path: 'documento/novo',component: FormDocumentoComponent}

];
