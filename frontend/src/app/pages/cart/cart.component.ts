import { Component } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent {
  value = 1;

  increment() {
    this.value += 1;
  }

  decrement() {
    if (this.value > 1) {
      this.value -= 1;
    }
  }
}
