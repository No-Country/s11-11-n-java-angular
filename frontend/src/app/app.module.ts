import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MaterialModule } from './material/material.module';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { RegisterComponent } from './core/auth/register/register.component';
import { UserEffect } from './core/store/model/user/User.Effects';
import { UserReducer } from './core/store/model/user/User.Reducer';
import { AppEffects } from './core/store/common/app.effects';

@NgModule({
  declarations: [AppComponent, RegisterComponent],
  imports: [
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    StoreModule.forRoot({ user: UserReducer }),
    EffectsModule.forRoot([UserEffect, AppEffects]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
