import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
  OnDestroy,
} from '@angular/core';
import { ProductCard } from '../../models/product-card.interface';
import { ProductService } from '../../services/product.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'product-list',
  template: `
    <section class="container-product-list">
      <product-card
        *ngFor="let product of productList | slice: 0 : limit"
        [product]="product"
      />
    </section>
  `,
  styles: [
    `
      .container-product-list {
        display: flex;
        gap: 1rem;
        flex-wrap: wrap;
      }

      @media (max-width: 992px) {
        .container-product-list {
          gap: 1rem;
          justify-content: center;
        }
      }

      @media (max-width: 768px) {
        .container-product-list {
          gap: 1rem;
          justify-content: center;
        }
      }
    `,
  ],
})
export class ProductListComponent implements OnInit, OnChanges, OnDestroy {
  @Input() limit?: number;
  @Input() productList!: ProductCard[];
  @Input() page?: number;
  private subscription!: Subscription;

  constructor(private productSvc: ProductService) {}

  ngOnInit(): void {
    this.getproducts();
    if (!this.limit) {
      // Change this when pagination is implemented
      this.limit = this.productList.length;
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['productList'] || changes['limit']) {
      this.productList = changes['productList']?.currentValue;
      this.limit = changes['limit']?.currentValue;
    }
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  getproducts() {
    this.subscription = this.productSvc.getProducts().subscribe((products) => {
      this.productList = products;
    });
  }
}
