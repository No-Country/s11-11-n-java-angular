/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable @typescript-eslint/no-empty-function */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from '../store/model/User.Model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  ///Provisional api for test register
  apiBaseUrl = 'http://localhost:3000/user';

  userRegistration(userData: Users): Observable<any> {
    return this.http.post(this.apiBaseUrl, userData);
  }
}
