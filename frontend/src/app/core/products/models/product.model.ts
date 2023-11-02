import { ProductCard } from './product-card.interface';

export interface Product extends ProductCard {
  category: string;
  stock: number;
}
