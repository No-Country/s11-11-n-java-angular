import { Component, Input } from '@angular/core';
import { ProductCard } from '../../models/product.interface';
import { ProductDetailsModule } from 'src/app/pages/product-details/product-details.module';
import { Router } from '@angular/router';

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
    private router: Router,
    private details: ProductDetailsModule
  ) {}

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

  OpenDetails() {
    this.router.navigate(['quantum/details']);
  }
}
