import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { ProductCard } from '../models/product-card.interface';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = `${environment.apiBaseUrl}/v1`;

  // START: Products array test
  // -----------------------------------------------------------------
  private products = new BehaviorSubject<ProductCard[]>([
    {
      id: 1,
      img: 'https://via.placeholder.com/150',
      name: 'Product 1',
      description: 'Desc 1',
      price: 100,
    },
    {
      id: 2,
      img: 'https://via.placeholder.com/150',
      name: 'Product 2',
      description: 'Desc 2',
      price: 200,
    },
    {
      id: 3,
      img: 'https://via.placeholder.com/150',
      name: 'Product 3',
      description: 'Desc 3',
      price: 300,
    },
    {
      id: 4,
      img: 'https://via.placeholder.com/150',
      name: 'Product 4',
      description: 'Desc 4',
      price: 400,
    },
    {
      id: 5,
      img: 'https://via.placeholder.com/150',
      name: 'Product 5',
      description: 'Desc 5',
      price: 770,
    },
    {
      id: 6,
      img: 'https://via.placeholder.com/150',
      name: 'Product 6',
      description: 'Desc 6',
      price: 260,
    },
    {
      id: 7,
      img: 'https://via.placeholder.com/150',
      name: 'Product 7',
      description: 'Desc 7',
      price: 330,
    },
    {
      id: 8,
      img: 'https://via.placeholder.com/150',
      name: 'Product 8',
      description: 'Desc 8',
      price: 450,
    },
    {
      id: 9,
      img: 'https://via.placeholder.com/150',
      name: 'Product 9',
      description: 'Desc 9',
      price: 120,
    },
    {
      id: 10,
      img: 'https://via.placeholder.com/150',
      name: 'Product 10',
      description: 'Desc 10',
      price: 150,
    },
    {
      id: 11,
      img: 'https://via.placeholder.com/150',
      name: 'Product 11',
      description: 'Desc 11',
      price: 869,
    },
    {
      id: 12,
      img: 'https://via.placeholder.com/150',
      name: 'Product 12',
      description: 'Desc 12',
      price: 353,
    },
    {
      id: 13,
      img: 'https://via.placeholder.com/150',
      name: 'Product 12',
      description: 'Desc 12',
      price: 353,
    },
    {
      id: 14,
      img: 'https://via.placeholder.com/150',
      name: 'Product 12',
      description: 'Desc 12',
      price: 353,
    },
  ]);
  getProducts() {
    return this.products.asObservable();
  }
  setProducts(products: ProductCard[]) {
    this.products.next(products);
  }
  // -----------------------------------------------------------------
  // FINAL: Products array test

  constructor(private http: HttpClient) {}

  getAllProducts() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    });

    return this.http.get(`${this.baseUrl}/products`, { headers });
  }

  createProduct(product: Product) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    });

    return this.http.post(`${this.baseUrl}/products`, product, { headers });
  }
}
