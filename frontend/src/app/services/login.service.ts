import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, tap } from 'rxjs';
import { Login } from '../shared/models/login.model';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private apiUrl = 'http://localhost:8080/api/authentication';
  public id?: number;
  public token?: string;
  private isLogedIn = new BehaviorSubject<boolean>(false);
  public isLogedIn$ = this.isLogedIn.asObservable();

  constructor(private http: HttpClient) {
    if (localStorage.getItem('token')) {
      this.isLogedIn.next(true);
    }
    if (localStorage.getItem('id')) {
      this.id = Number(localStorage.getItem('id'));
    }
  }
  get currentUserId() {
    if (!this.id) return undefined;
    return this.id;
  }

  Login(login: Login): Observable<any> {
    return this.http.post(`${this.apiUrl}/sign-in`, login);
  }
}
