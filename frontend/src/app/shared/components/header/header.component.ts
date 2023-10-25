import { Component } from '@angular/core';

@Component({
  selector: 'shared-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  showSidebar = false;

  showMenu() {
    this.showSidebar = !this.showSidebar;
  }
}
