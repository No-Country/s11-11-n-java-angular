import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './core/auth/register/register.component';

import { ProductDetailsModule } from '../app/pages/product-details/product-details.module';

const routes: Routes = [
  { path: 'login', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'auth',
    loadChildren: () =>
      import('./pages/auth/auth-routing.module').then(
        (m) => m.AuthRoutingModule
      ),
  },
  { path: '', redirectTo: 'quantum', pathMatch: 'full' },
  {
    path: 'quantum',
    loadChildren: () =>
      import('./layout/layout.module').then((m) => m.LayoutModule),
  },

  { path: 'register', component: RegisterComponent },
  {
    path: '',
    redirectTo: 'quantum',
    pathMatch: 'full',
  },
  { path: '', redirectTo: 'quantum', pathMatch: 'full' },
  {
    path: 'register',
    loadChildren: () =>
      import('./core/auth/register/register.component').then(
        (m) => m.RegisterComponent
      ),
  },
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
