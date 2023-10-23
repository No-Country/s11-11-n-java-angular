import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'home', // http://localhost:4200/quantum/home
        loadChildren: () =>
          import('../pages/home/home.module').then((m) => m.HomeModule),
      },
      {
        path: 'search', // http://localhost:4200/quantum/search
        loadChildren: () =>
          import('../pages/search-results/search-results.module').then(
            (m) => m.SearchResultsModule
          ),
      },
      {
        path: '', // http://localhost:4200/quantum
        redirectTo: 'search',
        pathMatch: 'full',
      },
    ],
  },
  {
    path: '**', // http://localhost:4200/quantum/any...
    redirectTo: '',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LayoutRoutingModule {}
