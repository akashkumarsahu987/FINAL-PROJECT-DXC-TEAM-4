import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http:HttpClient) { }

  public displayBooks(bookname:string):Observable<any>{
    return this.http.get("https://www.googleapis.com/books/v1/volumes?q="+bookname);
  }

  public displayCategoryBooks(categoryname:string):Observable<any>{
    return this.http.get("https://www.googleapis.com/books/v1/volumes?q=subject:"+categoryname);
  }

}
