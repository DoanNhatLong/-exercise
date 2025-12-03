package entity;

public class Book extends Publication{
    String isbn;
    String author;

    public Book() {
    }

    public Book(int year, String name, String date, String isbn, String author) {
        super(year, name, date);
        this.isbn = isbn;
        this.author = author;
    }

    public String toCSV(){
        return "Book,"+super.toCSV()+","+getIsbn()+","+getAuthor();
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                "} " + super.toString();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
