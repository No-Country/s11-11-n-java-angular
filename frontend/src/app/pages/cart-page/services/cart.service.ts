import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { Observable, BehaviorSubject } from 'rxjs';
import { CartProduct } from '../models/cart.model';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private _baseUrl = environment.apiBaseUrl;
  private cartList: CartProduct[] = [];

  private cartListSubject = new BehaviorSubject<CartProduct[]>([]);
  getCartList(): Observable<CartProduct[]> {
    return this.cartListSubject.asObservable();
  }
  addProductInCart(product: CartProduct) {
    this.cartList.push(product);
    this.cartListSubject.next([...this.cartList]);
    localStorage.setItem('cart', JSON.stringify(this.cartList));
  }
  removeProduct(id: number) {
    const index = this.cartList.findIndex((item) => item.id === id);
    this.cartList.splice(index, 1);
    this.cartListSubject.next([...this.cartList]);
    localStorage.setItem('cart', JSON.stringify(this.cartList));
  }

  increaseProductQuantity(id: number) {
    const index = this.cartList.findIndex((p) => p.id === id);
    if (index !== -1) {
      this.cartList[index].quantity += 1;
      this.cartListSubject.next([...this.cartList]);
      localStorage.setItem('cart', JSON.stringify(this.cartList));
    }
  }

  decreaseProductQuantity(id: number) {
    const index = this.cartList.findIndex((p) => p.id === id);
    if (index !== -1) {
      this.cartList[index].quantity -= 1;
      this.cartListSubject.next([...this.cartList]);
      localStorage.setItem('cart', JSON.stringify(this.cartList));
    }
  }

  constructor(private _http: HttpClient) {
    const cart = localStorage.getItem('cart');
    if (cart) {
      this.cartList = JSON.parse(cart);
      this.cartListSubject.next([...this.cartList]);
    }
  }
}
