import { Component, Input } from '@angular/core';
import { ProductCard } from '../../models/product.interface';

@Component({
  selector: 'product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss'],
})
export class ProductCardComponent {
  @Input() product!: ProductCard;
  iconCart = 'add';
  iconWish = 'add';

  addToCart(id: number) {
    if (this.iconCart === 'remove') {
      this.iconCart = 'add';
    } else {
      this.iconCart = 'remove';
      console.log('Add to cart:', id);
    }
    // this.iconCart = this.iconCart === 'remove' ? 'add' : 'remove';
  }

  addToWishlist(id: number) {
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
