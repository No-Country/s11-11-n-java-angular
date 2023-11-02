import { Component } from '@angular/core';
import { ProductCard } from 'src/app/core/products/models/product.interface';
import { ProductCardComponent as ProductCardComponent1 } from 'src/app/core/products/components/product-card/product-card.component';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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
