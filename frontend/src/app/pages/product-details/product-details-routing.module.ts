import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailsComponent } from './product-details.component';
import { ProductDetailsModule } from '../product-details/product-details.module';

const routes: Routes = [
  { path: 'product-details', component: ProductDetailsComponent },
  { path: '**', redirectTo: '' },
  {
    path: 'product-details',
    loadChildren: () =>
      import('../product-details/product-details.module').then(
        (m) => m.ProductDetailsModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductDetailsRoutingModule {}
