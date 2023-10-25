import { Component } from '@angular/core';

@Component({
  selector: 'app-layout',
  template: `
    <shared-header />
    <router-outlet />
    <shared-footer />
  `,
  styles: [``],
})
export class LayoutComponent {}
