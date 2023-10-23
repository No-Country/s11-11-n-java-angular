import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { ProductCard } from '../models/product.interface';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = environment.apiBaseUrl;

  // INICIO: Products array test
  // -----------------------------------------------------------------
  private products = new BehaviorSubject<ProductCard[]>([
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 1',
      description: 'Desc 1',
      price: 100,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 2',
      description: 'Desc 2',
      price: 200,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 3',
      description: 'Desc 3',
      price: 300,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 4',
      description: 'Desc 4',
      price: 400,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 5',
      description: 'Desc 5',
      price: 770,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 6',
      description: 'Desc 6',
      price: 260,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 7',
      description: 'Desc 7',
      price: 330,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 8',
      description: 'Desc 8',
      price: 450,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 9',
      description: 'Desc 9',
      price: 120,
    },
    {
      img: 'https://via.placeholder.com/250',
      name: 'Product 10',
      description: 'Desc 10',
      price: 150,
    },
  ]);
  getProducts() {
    return this.products.asObservable();
  }
  setProducts(products: ProductCard[]) {
    this.products.next(products);
  }
  // -----------------------------------------------------------------
  // FIN: Products array test

  constructor(private http: HttpClient) {}

  getAllProducts() {
    return this.http.get(`${this.baseUrl}/products`);
  }
}
