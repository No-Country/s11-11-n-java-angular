import { createEntityAdapter } from '@ngrx/entity';
import { UserModel, Users } from '../User.Model';

export const UserAdapter = createEntityAdapter<Users>();

export const UserState: UserModel = UserAdapter.getInitialState();
