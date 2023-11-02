import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { RouterModule } from '@angular/router';
import { FooterComponent } from './components/footer/footer.component';
import { SearchBoxComponent } from './components/search-box/search-box.component';
import { CartModalComponent } from './components/cart-modal/cart-modal.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SearchBoxComponent,
    CartModalComponent,
  ],
  imports: [CommonModule, RouterModule],
  exports: [HeaderComponent, FooterComponent],
})
export class SharedModule {}
