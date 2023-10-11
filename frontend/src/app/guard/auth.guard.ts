import { CanActivateFn } from '@angular/router';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
export const authGuard: CanActivateFn = (route, state) => {
  return true;
};
