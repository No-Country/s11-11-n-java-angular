import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductListComponent } from 'src/app/core/products/components/product-list/product-list.component';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent {
  constructor(
    private route: ActivatedRoute,
    private producto: ProductListComponent
  ) {}

  productos: any[] = [];
}
console.log('hola');
