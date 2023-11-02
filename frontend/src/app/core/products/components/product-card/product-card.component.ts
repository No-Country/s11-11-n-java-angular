import { Component, Input } from '@angular/core';

import { ProductCard } from '../../models/product-card.interface';
import { CartService } from 'src/app/pages/cart-page/services/cart.service';
import { NotifyService } from 'src/app/services/notify.service';


@Component({
  selector: 'product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss'],
})
export class ProductCardComponent {
  @Input() product!: ProductCard;
  iconCart = 'add';
  iconWish = 'add';


  constructor(
    private _cartSvc: CartService,
    private _notifySvc: NotifyService
  ) {}

  addToCart(id: number | undefined) {
    if (this.iconCart === 'remove') {
      this.iconCart = 'add';
      this._cartSvc.removeProduct(id);
    } else {
      this.iconCart = 'remove';
      this._cartSvc.addProductInCart({ id, quantity: 1 });
    }
  }

  addToWishlist(id: number | undefined) {
    if (this.iconWish === 'remove') {
      this.iconWish = 'add';
    } else {
      this.iconWish = 'remove';
      console.log('Add to wishlist:', id);
    }
    // this.iconWish = this.iconWish === 'remove' ? 'add' : 'remove';
  }

  viewProduct() {
    console.log('View product:', this.product.id);
  }
}
