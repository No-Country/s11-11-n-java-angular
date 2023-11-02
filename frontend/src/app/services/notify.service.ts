import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class NotifyService {
  constructor(private matsnack: MatSnackBar) {}

  showSuccess(message: string, title: string) {
    this.matsnack.open(message, title);
  }

  showError(message: string, title: string) {
    this.matsnack.open(message, title);
  }
}
