import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  categoryList = [
    {
      urlImg: 'assets/images/home-img/category-icons/icon-action&adventure.svg',
      title: 'Acción y Aventura',
    },
    {
      urlImg: 'assets/images/home-img/category-icons/icon-arcade.svg',
      title: 'Arcade',
    },
    {
      urlImg: 'assets/images/home-img/category-icons/icon-deport.svg',
      title: 'Deportes',
    },
    {
      urlImg: 'assets/images/home-img/category-icons/icon-casino.svg',
      title: 'Casino',
    },
    {
      urlImg: 'assets/images/home-img/category-icons/icon-strategy.svg',
      title: 'Estrategia',
    },
  ];

  premiereList = [];
  // TODO: Get data PRODUCTS from API
}
