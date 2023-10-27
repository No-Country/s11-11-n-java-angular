import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ProductService } from 'src/app/core/products/services/product.service';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.scss'],
})
export class SearchResultsComponent implements OnInit, OnDestroy {
  subscription!: Subscription;
  productLength!: number;

  constructor(private productSvc: ProductService) {}

  ngOnInit(): void {
    this.getProductLength();
  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  getProductLength(): void {
    this.subscription = this.productSvc.getProducts().subscribe((products) => {
      this.productLength = products.length;
    });
  }
}
