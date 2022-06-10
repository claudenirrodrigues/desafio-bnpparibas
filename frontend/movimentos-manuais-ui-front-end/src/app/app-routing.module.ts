import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MovimentoManualComponent } from './pages/movimento-manual/movimento-manual.component';


const routes: Routes = [
  {
    path:'',
    component: MovimentoManualComponent,
    children: [
      {path:'', redirectTo: 'movimento-manual', pathMatch: 'full'}
    ]
  },
  { path:'movimento-manual', component: MovimentoManualComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
