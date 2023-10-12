/* eslint-disable @ngrx/prefer-effect-callback-in-block-statement */
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { UserService } from 'src/app/core/services/user.service';
import { beginRegister } from './User.Action';
import { exhaustMap, map, catchError, of } from 'rxjs';
import { showAlert } from '../../common/app.action';

@Injectable()
export class UserEffect {
  constructor(
    private action$: Actions,
    private service: UserService
  ) {}

  _userregister = createEffect(() =>
    this.action$.pipe(
      ofType(beginRegister),
      exhaustMap((action) =>
        this.service.userRegistration(action.userData).pipe(
          map(() =>
            showAlert({
              message: 'Registered successfully.',
              resulttype: 'pass',
            })
          ),
          catchError((_error) =>
            of(
              showAlert({
                message: 'Registration Failed due to: ' + _error.message,
                resulttype: 'fail',
              })
            )
          )
        )
      )
    )
  );
}
