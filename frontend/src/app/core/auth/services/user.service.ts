/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable @typescript-eslint/no-empty-function */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from '../../store/model/User.Model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  ///Provisional api for test register
  apiBaseUrl = environment.apiBaseUrl;

  userRegistration(userData: Users): Observable<any> {
    return this.http.post(this.apiBaseUrl, userData);
  }
}
