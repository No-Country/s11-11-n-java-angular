import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { MaterialModule } from './material/material.module';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeModule } from './pages/home/home.module';

import { LayoutModule } from './layout/layout.module';
import { SharedModule } from './shared/shared.module';

import { SearchResultsModule } from './pages/search-results/search-results.module';
import { ProductDetailsModule } from './pages/product-details/product-details.module';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { UserReducer } from './core/store/model/user/User.Reducer';
import { AppEffects } from './core/store/common/app.effects';
import { UserEffect } from './core/store/model/user/User.Effects';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    HomeModule,
    LayoutModule,
    SharedModule,
    SearchResultsModule,
    ProductDetailsModule,
    StoreModule.forRoot({ user: UserReducer }),
    EffectsModule.forRoot([AppEffects, UserEffect]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
