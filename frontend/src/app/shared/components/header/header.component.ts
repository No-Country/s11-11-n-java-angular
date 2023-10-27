import { Component } from '@angular/core';

@Component({
  selector: 'shared-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  showSidebar = false;
  showSearchBox = false;

  showMenu() {
    this.showSidebar = !this.showSidebar;
    this.showSearchBox = false;
  }

  showSearch() {
    this.showSearchBox = !this.showSearchBox;
    this.showSidebar = false;
  }

  hideSearch() {
    this.showSearchBox = false;
  }
}
