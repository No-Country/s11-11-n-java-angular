import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { MaterialModule } from './material/material.module';

import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { LoginModule } from './pages/auth/pages/login/login.module';
import { HomeModule } from './pages/home/home.module';

import { LayoutModule } from './layout/layout.module';
import { SharedModule } from './shared/shared.module';

import { SearchResultsModule } from './pages/search-results/search-results.module';
import { ProductDetailsModule } from './pages/product-details/product-details.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LoginModule,
    HomeModule,
    SearchResultsModule,
    ProductDetailsModule,
    MaterialModule,
    SharedModule,
    LayoutModule,

    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
