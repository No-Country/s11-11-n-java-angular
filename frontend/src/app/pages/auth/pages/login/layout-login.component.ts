import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './layout-login.component.html',
  styleUrls: ['./layout-login.component.scss'],
})
export class LayoutLoginComponent {
  loginForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
    ]),
  });

  onSubmit() {
    if (this.loginForm.valid) {
      // Realizar la lógica de inicio de sesión
    }
  }
}
