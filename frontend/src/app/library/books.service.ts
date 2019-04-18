import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "./book";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {map} from "rxjs/operators";
import {BooksResponse} from "./books-response";


@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(private http: HttpClient) {
  }

  getBooks(): Observable<Book[]> {
    return this.http.get<BooksResponse>(environment.baseUrl + "/library/books")
      .pipe(
        map(booksResponse => Book.toBooks(booksResponse))
      );

  }

}
