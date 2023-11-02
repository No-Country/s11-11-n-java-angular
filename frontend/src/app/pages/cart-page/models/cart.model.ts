import { ProductCard } from 'src/app/core/products/models/product-card.interface';

export interface CartProduct {
  id?: number;
  quantity: number;
}

export interface LocalCart {
  product: ProductCard;
  quantity: number;
}
