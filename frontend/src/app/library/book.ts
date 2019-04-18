export class Book {
  private constructor(
    public id: number,
    public title: string,
    public type: string,
    public imageLink: string
  ) {
  }

  private static of(bookResponse: string[]) {
    return new Book(
      parseInt(bookResponse[0]),
      bookResponse[1],
      bookResponse[2],
      bookResponse[3]
    );
  }

  static toBooks(books: string[][]): Book[] {
    return books
      .map(book => this.of(book));
  }
}
