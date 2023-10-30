import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LayoutLoginComponent } from './pages/auth/pages/login/layout-login.component';
import { ProductDetailsComponent } from './pages/product-details/product-details.component';

const routes: Routes = [
  { path: 'login', component: LayoutLoginComponent },
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
  { path: '**', redirectTo: 'search' },
  {
    path: '',
    redirectTo: 'quantum',
    pathMatch: 'full',
  },
  { path: 'product-details', component: ProductDetailsComponent },

  {
    path: 'product-details',
    loadChildren: () =>
      import('./pages/product-details/product-details.module').then(
        (m) => m.ProductDetailsModule
      ),
  },
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
