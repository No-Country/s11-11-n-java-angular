import { NgModule } from '@angular/core';
import { LayoutLoginComponent } from './layout-login.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'login', component: LayoutLoginComponent },
  { path: '**', redirectTo: '' },
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LoginRoutingModule {}
