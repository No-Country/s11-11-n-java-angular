/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { createReducer } from '@ngrx/store';
import { UserState } from './User.State';

const _userReducer = createReducer(UserState);

// eslint-disable-next-line @typescript-eslint/no-empty-function
export function UserReducer(state: any, action: any) {}
