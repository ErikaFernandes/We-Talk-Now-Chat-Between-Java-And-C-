import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Message } from './message';
import { MESSAGES } from './mock-messages';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({ providedIn: 'root' })
export class MessageService {
private api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

    getMessage(): Observable<any> {
        return  this.http.get<any>(`${this.api}/message`);
    }


    postMessage(message: any): Observable<any> {
        return this.http.post<any>(`${this.api}/message`, message);

  }

}
