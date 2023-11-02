import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreateProductRoutingModule } from './create-product-routing.module';
import { CreateProductComponent } from './create-product.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [CreateProductComponent],
  imports: [CommonModule, CreateProductRoutingModule, ReactiveFormsModule],
})
export class CreateProductModule {}
