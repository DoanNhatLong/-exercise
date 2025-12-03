package repository;

import entity.Book;
import entity.Magazine;
import entity.Publication;

import java.util.List;

public interface ILibraryRepository {
    void addBook(Book temp);

    void addMagazine(Magazine temp);

    void display();

    void addAuthor();

    void displayTop();

    void search(int temp);

    List<Publication> getAll();
}
