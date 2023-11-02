import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/core/products/services/product.service';
import { NotifyService } from 'src/app/services/notify.service';
import { LocalCart } from './models/cart.model';
import { CartService } from './services/cart.service';
import { ProductCard } from 'src/app/core/products/models/product.interface';

@Component({
  selector: 'cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.scss'],
})
export class CartPageComponent implements OnInit {
  value = 1;

  cartList!: LocalCart[];
  allProducts!: ProductCard[];
  totalPrice!: number;
  cartLength!: number;

  constructor(
    private _productService: ProductService,
    private _notifySvc: NotifyService,
    private _cartSvc: CartService
  ) {}

  ngOnInit(): void {
    this._productService.getProducts().subscribe((res) => {
      this.allProducts = res;
    });

    this._cartSvc.getCartList().subscribe((res) => {
      // Buscando los productos desde del carrito en la lista de productos
      this.cartList = res.map((item) => {
        return {
          product: this.allProducts.find(
            (p) => p.id === item.id
          ) as ProductCard,
          quantity: item.quantity,
        };
      });

      this.cartLength = this.cartList.length;
      this.totalPrice = this.cartList.reduce((acc, item) => {
        return acc + item.product.price * item.quantity;
      }, 0);
    });
  }

  increment(quantity: number, id: number) {
    if (quantity < 10) {
      this._cartSvc.increaseProductQuantity(id);
      return;
    }
    this._notifySvc.showError('No puedes agregar más de 10', 'Límite');
  }

  decrement(quantity: number, id: number) {
    if (quantity > 1) {
      this._cartSvc.decreaseProductQuantity(id);
      return;
    }
    this._notifySvc.showError('No puedes agregar menos de 1', 'Límite');
  }

  onPayment() {
    if (confirm('¿Está seguro de realizar el pago?')) {
      this._notifySvc.showSuccess('Pago realizado', 'Ok');
    }
  }

  removeAt(id: number) {
    this._cartSvc.removeProduct(id);
  }
}
