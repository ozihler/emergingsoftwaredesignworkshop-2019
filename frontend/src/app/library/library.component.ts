import {Component, OnInit} from '@angular/core';
import {Book} from "./book";
import {BooksService} from "./books.service";

@Component({
  selector: 'app-books-overview',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  availableBooks: Book[];
  selectedBooksBasked: Book[];
  draggedBook: Book;

  constructor(private booksService: BooksService) {
  }

  ngOnInit() {
    this.selectedBooksBasked = [];
    this.booksService.getBooks()
      .subscribe((books: Book[]) => {
        this.availableBooks = books
      });
  }

}
