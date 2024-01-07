import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  // ---------- add user - create -------
  adduser(user: User){
    return this.http.post<User>(`${this.url}add`, user)
  }

  // ----- Get user - read ----------
  getUsers(): Observable<any[]>{
    return this.http.get<any[]>(this.url+'users')
  }

  // ------- Get user by id - read ---------
  getUserById(id?: number): Observable<User>{
    return this.http.get<User>(`${this.url}user/${id}`)
  }

  // ------- Update user - update -------
  updateUser(id?: number, user?: any): Observable<any>{
    return this.http.put<any>(`${this.url}update/${id}`, user)
  }

  // ------- Delete user - Delete -------
  deleteUser(id: number): Observable<any>{
    return this.http.delete<any>(`${this.url}delete/${id}`)
  }
}
