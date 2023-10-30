import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutAuthComponent } from './layout-auth/layout-auth.component';
import { ProductsModule } from '../../core/products/products.module';

import { ProductCardComponent } from 'src/app/core/products/components/product-card/product-card.component';

const routes: Routes = [
  {
    path: 'login',
    component: LayoutAuthComponent,
    children: [
      {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full',
      },
      {
        path: 'login',
        loadChildren: () =>
          import('./pages/login/login.module').then((m) => m.LoginModule),
      },
      {
        path: 'products',
        loadChildren: () =>
          import('../../core/products/products.module').then(
            (m) => m.ProductsModule
          ),
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}
