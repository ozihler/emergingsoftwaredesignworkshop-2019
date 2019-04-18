import {Injectable} from '@angular/core';
import {Book} from "./book";
import {environment} from "../../environments/environment";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class FeeService {

  constructor(private http: HttpClient) {
  }

  calculateFee(books: Book[]): Observable<string> {
    const booksCommand: string[][] = books.map(book => [`${book.id}`, book.title, book.type, book.imageLink]);

    return this.http.post<string>(environment.baseUrl + "/library/fee", booksCommand)
      .pipe(
        map(response => response)
      );

  }
}
