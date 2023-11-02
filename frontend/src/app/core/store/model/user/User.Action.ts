import { createAction, props } from '@ngrx/store';
import { Users } from '../User.Model';

export const BEGIN_REGISTER = '[auth], begin Register';

export const beginRegister = createAction(
  BEGIN_REGISTER,
  props<{ userData: Users }>()
);
