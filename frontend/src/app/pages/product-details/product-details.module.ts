import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from 'src/app/shared/components/header/header.component';

import { ProductDetailsRoutingModule } from './product-details-routing.module';
import { ProductDetailsComponent } from '../product-details/product-details.component';

@NgModule({
  declarations: [ProductDetailsComponent],
  imports: [CommonModule, ProductDetailsRoutingModule],
})
export class ProductDetailsModule {}
