import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { LayoutAuthComponent } from './layout-auth/layout-auth.component';

@NgModule({
  declarations: [LayoutAuthComponent],
  imports: [CommonModule, AuthRoutingModule],
})
export class AuthModule {}
