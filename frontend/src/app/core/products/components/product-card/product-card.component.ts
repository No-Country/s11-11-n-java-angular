import { Component, Input } from '@angular/core';
import { ProductCard } from '../../models/product.interface';

@Component({
  selector: 'product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss'],
})
export class ProductCardComponent {
  @Input() product!: ProductCard;
}
