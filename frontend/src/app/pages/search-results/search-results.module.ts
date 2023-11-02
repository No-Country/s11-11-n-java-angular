import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SearchResultsRoutingModule } from './search-results-routing.module';
import { ProductsModule } from 'src/app/core/products/products.module';
import { SearchResultsComponent } from './search-results.component';

@NgModule({
  declarations: [SearchResultsComponent],
  imports: [CommonModule, SearchResultsRoutingModule, ProductsModule],
})
export class SearchResultsModule {}
