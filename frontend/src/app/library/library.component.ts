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
  selectedBooksBasket: Book[];
  draggedBook: Book;

  constructor(private booksService: BooksService) {
  }

  ngOnInit() {
    this.initialise();
  }

  private initialise() {
    this.selectedBooksBasket = [];
    this.booksService.getBooks()
      .subscribe((books: Book[]) => {
        this.availableBooks = books
      });
  }

  drop($event: any) {
    if(this.draggedBook) {
      let draggedBookIndex = this.findIndex(this.draggedBook);
      this.selectedBooksBasket = [...this.selectedBooksBasket, this.draggedBook];
      this.availableBooks = this.availableBooks.filter((val,i) => i!=draggedBookIndex);
      this.draggedBook = null;
    }
  }

  findIndex(book: Book) {
    let index = -1;
    for(let i = 0; i < this.availableBooks.length; i++) {
      if(book.id === this.availableBooks[i].id) {
        index = i;
        break;
      }
    }
    return index;
  }

  dragStart($event: any, book: Book) {
    this.draggedBook = book;
  }

  dragEnd($event: any) {
    this.draggedBook = null;
  }

  resetSelectedBooksBasket() {
    this.initialise();
  }
}
