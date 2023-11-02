import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailsComponent } from './product-details.component';

const routes: Routes = [
  { path: '', component: ProductDetailsComponent },
  /* {
    path: 'home',
    loadChildren: () =>
      import('../home/home.module').then((m) => m.HomeModule),
  }, */

  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductDetailsRoutingModule {}
