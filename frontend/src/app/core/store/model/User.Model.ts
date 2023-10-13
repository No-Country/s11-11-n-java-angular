import { EntityState } from '@ngrx/entity';

export interface Users {
  Fullname: string;
  Email: string;
  Password: string;
  PersonalInfo: string;
  ShippingAddress: string;
  Country: string;
  City: string;
  Zip: string;
  PaymentPreferences: string;
}

// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface UserModel extends EntityState<Users> {}
