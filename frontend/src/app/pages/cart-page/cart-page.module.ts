import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartPageRoutingModule } from './cart-page-routing.module';
import { CartPageComponent } from './cart-page.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [CartPageComponent],
  imports: [CommonModule, CartPageRoutingModule, FormsModule],
})
export class CartPageModule {}
