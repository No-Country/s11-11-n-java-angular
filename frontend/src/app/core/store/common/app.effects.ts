import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { MatSnackBar } from '@angular/material/snack-bar';
import { emptyaction, showAlert } from './app.action';
import { exhaustMap, map } from 'rxjs';

@Injectable()
export class AppEffects {
  constructor(
    private $action: Actions,
    private _snackBar: MatSnackBar
  ) {}

  _showalert = createEffect(() =>
    // eslint-disable-next-line @ngrx/prefer-effect-callback-in-block-statement, prettier/prettier
    this.$action.pipe(
      ofType(showAlert),
      exhaustMap((action) => {
        return this.Shownackbaralert(action.message, action.resulttype)
          .afterDismissed()
          .pipe(
            map(() => {
              return emptyaction();
            })
          );
      })
    )
  );

  Shownackbaralert(message: string, resulttype = 'fail') {
    const _class = resulttype == 'pass' ? 'green-snackbar' : 'red-snackbar';
    return this._snackBar.open(message, 'OK', {
      verticalPosition: 'top',
      horizontalPosition: 'end',
      duration: 5000,
      panelClass: [_class],
    });
  }
}
