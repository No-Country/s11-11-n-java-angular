import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'quantum', pathMatch: 'full' },
  {
    path: 'login',
    loadChildren: () =>
      import('./core/auth/login/login.module').then((m) => m.LoginModule),
  },
  {
    path: 'quantum',
    loadChildren: () =>
      import('./layout/layout.module').then((m) => m.LayoutModule),
  },
  {
    path: 'register',
    loadChildren: () =>
      import('./core/auth/register/register.module').then(
        (m) => m.RegisterModule
      ),
  },
  { path: '**', redirectTo: 'quantum' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
