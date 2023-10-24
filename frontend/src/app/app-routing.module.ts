import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LayoutLoginComponent } from './pages/auth/pages/login/layout-login.component';

const routes: Routes = [
  { path: 'login', component: LayoutLoginComponent },
  {
    path: 'auth',
    loadChildren: () =>
      import('./pages/auth/auth-routing.module').then(
        (m) => m.AuthRoutingModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
