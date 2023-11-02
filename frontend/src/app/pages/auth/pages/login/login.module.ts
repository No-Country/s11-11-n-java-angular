import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReactiveFormsModule } from '@angular/forms';
import { LoginRoutingModule } from './login-routing.module';
import { LayoutLoginComponent } from './layout-login.component';

import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [LayoutLoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ReactiveFormsModule,

    HttpClientModule,
  ],
  providers: [],
})
export class LoginModule {}
