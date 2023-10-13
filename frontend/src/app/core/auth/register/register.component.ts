import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { beginRegister } from '../../store/model/user/User.Action';
import { showAlert } from '../../store/common/app.action';
import { Users } from '../../store/model/User.Model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  constructor(
    private store: Store,
    private builder: FormBuilder
  ) {}

  registerForm = this.builder.group({
    fullName: this.builder.control(
      '',
      Validators.compose([Validators.required, Validators.minLength(5)])
    ),
    password: this.builder.control('', Validators.required),
    confirmpassword: this.builder.control('', Validators.required),
    personalInfo: this.builder.control('', Validators.required),
    email: this.builder.control(
      '',
      Validators.compose([Validators.required, Validators.email])
    ),
    shippingAdd: this.builder.control('', Validators.required),
    country: this.builder.control('', Validators.required),
    city: this.builder.control('', Validators.required),
    zip: this.builder.control('', Validators.required),
    paymentPref: this.builder.control('', Validators.required),
  });

  ProceedRegister() {
    if (this.registerForm.valid) {
      if (
        this.registerForm.value.password ===
        this.registerForm.value.confirmpassword
      ) {
        const _userobj: Users = {
          Fullname: this.registerForm.value.fullName as string,
          Password: this.registerForm.value.password as string,
          PersonalInfo: this.registerForm.value.personalInfo as string,
          Email: this.registerForm.value.email as string,
          ShippingAddress: this.registerForm.value.shippingAdd as string,
          Country: this.registerForm.value.country as string,
          City: this.registerForm.value.city as string,
          Zip: this.registerForm.value.zip as string,
          PaymentPreferences: this.registerForm.value.paymentPref as string,
        };
        this.store.dispatch(beginRegister({ userData: _userobj }));
      } else {
        this.store.dispatch(
          showAlert({ message: 'Password mismatch', resulttype: 'fail' })
        );
      }
    }
  }
}
