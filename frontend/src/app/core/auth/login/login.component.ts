import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { Login } from '../../../shared/models/login.model';
import { NotifyService } from 'src/app/services/notify.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  loginForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
    ]),
  });

  constructor(
    private loginService: LoginService,
    private notifySvc: NotifyService,
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
      this.router.navigate(['quantum/home']);
    });

    console.log(this.loginForm.value);
    console.log('conexion completada  redirigido a home');
  }

  register() {
    this.router.navigate(['quantum/home']);
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      // Realizar la lógica de inicio de sesión
      this.notifySvc.showError(
        'Error al iniciar sesión',
        'Error con tus datos'
      );

      return;
    }
    const user: Login = {
      email: this.loginForm.value.email,
      password: this.loginForm.value.password,
    };
    this.loginService.Login(user).subscribe({
      next: () => {
        this.notifySvc.showSuccess(
          'Inicio de sesión exitoso',
          'Bienvenido a QuantumGamer'
        );
        this.router.navigate(['']);
        setTimeout(() => {
          location.href = '/quantum/home';
        }, 3000);
      },
      error: (err) => {
        this.notifySvc.showError(
          'Error al iniciar sesión',
          'Error con tus datos'
        );
      },
    });
  }
}
