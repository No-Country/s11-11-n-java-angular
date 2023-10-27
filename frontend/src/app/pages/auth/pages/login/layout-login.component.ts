import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../../../../services/login.service';

import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Login } from '../../../../shared/models/login.model';

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

  constructor(
    private loginService: LoginService,

    private snackBar: MatSnackBar,
    private router: Router
  ) {}

  get email() {
    return this.loginForm.get('email');
  }
  get password() {
    return this.loginForm.get('password');
  }

  login() {
    this.loginService.Login(this.loginForm.value).subscribe((res: any) => {
      this.loginService.id = res.id;
      this.loginService.token = res.token;
      localStorage.setItem('id', res.id);
      localStorage.setItem('token', res.token);
      this.router.navigate(['']);
    });

    console.log(this.loginForm.value);
    console.log('conexion completada  redirigido a home');
  }

  onSubmit() {
    if (!this.loginForm.valid) {
      // Realizar la lógica de inicio de sesión
      this.snackBar.open('Formulario inválido', 'Error con tus datos');

      return;
    }
    const user: Login = {
      email: this.loginForm.value.email,
      password: this.loginForm.value.password,
    };
    this.loginService.Login(user).subscribe({
      next: () => {
        this.snackBar.open('Login correcto', 'Bienvenido');
        this.router.navigate(['']);
      },
      error: (err) => {
        this.snackBar.open('Error al iniciar sesión', 'Error con tus datos');
      },
    });
  }
}
