import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { UserReducer } from './core/store/model/user/User.Reducer';
import { AppEffects } from './core/store/common/app.effects';
import { UserEffect } from './core/store/model/user/User.Effects';
import { MaterialModule } from './material/material.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    StoreModule.forRoot({ user: UserReducer }),
    EffectsModule.forRoot([AppEffects, UserEffect]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
