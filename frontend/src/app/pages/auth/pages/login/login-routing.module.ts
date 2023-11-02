import { NgModule } from '@angular/core';
import { LayoutLoginComponent } from './layout-login.component';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from 'src/app/core/auth/register/register.component';

const routes: Routes = [
  { path: 'login', component: LayoutLoginComponent },
  { path: '**', redirectTo: '' },
  { path: 'register', component: RegisterComponent },
  { path: '**', redirectTo: '' },
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LoginRoutingModule {}
