import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../material/material.module';

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, RouterModule, MaterialModule],
  exports: [HeaderComponent],
})
export class SharedModule {}
