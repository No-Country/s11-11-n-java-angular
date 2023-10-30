import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductDetailsRoutingModule } from './product-details-routing.module';
import { ProductDetailsComponent } from '../product-details/product-details.component';

import { ProductsModule } from 'src/app/core/products/products.module';

@NgModule({
  declarations: [ProductDetailsComponent],

  imports: [CommonModule, ProductDetailsRoutingModule, ProductsModule],
})
export class ProductDetailsModule {}
