import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HttpImageService {

  public baseUrl: string = 'api/';

  constructor(private httpClient: HttpClient) { }

  getIds() {
    return this.httpClient.get<number[]>(this.baseUrl + 'id');
  }
}
