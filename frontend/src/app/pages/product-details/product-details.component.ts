import { Component } from '@angular/core';
import { ProductService } from 'src/app/core/products/services/product.service';
import { Subscription } from 'rxjs';
import { Observable } from 'rxjs';
import { ProductCard } from 'src/app/core/products/models/product.interface';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent {
  products!: Observable<ProductCard[]>;

  constructor(private productSvc: ProductService) {}

  ngOnInit(): void {
    this.products = this.productSvc.getProducts();

    console.log({ getProducts: this.products });
  }
}
