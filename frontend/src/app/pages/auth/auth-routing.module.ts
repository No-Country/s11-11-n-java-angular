import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutAuthComponent } from './layout-auth/layout-auth.component';

const routes: Routes = [
  {
    path: 'login',
    component: LayoutAuthComponent,
    children: [
      {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full',
      },
      {
        path: 'login',
        loadChildren: () =>
          import('./pages/login/login.module').then((m) => m.LoginModule),
      },
      /* {
        path: 'register',
        loadChildren: () =>
          import('./pages/register/register.module').then(
            (m) => m.RegisterModule
          ),
      },
      {
        path: 'register-gamer',
        loadChildren: () =>
          import('./pages/register-doctor/register-doctor.module').then(
            (m) => m.RegisterDoctorModule
          ),
      }, */
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}
