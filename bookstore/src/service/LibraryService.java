package service;

import entity.Book;
import entity.Magazine;
import repository.ILibraryRepository;
import repository.LibraryRepository;
import view.LibraryView;

public class LibraryService implements ILibraryService {
    public static ILibraryRepository libraryRepository = new LibraryRepository();

    @Override
    public void addBook() {
        Book temp = LibraryView.inputBook();
        libraryRepository.addBook(temp);
    }

    @Override
    public void addMagazine() {
        Magazine temp = LibraryView.inputMagazine();
        libraryRepository.addMagazine(temp);
    }

    @Override
    public void display() {
        libraryRepository.display();

    }

    @Override
    public void addAuthor() {
        libraryRepository.addAuthor();
    }

    @Override
    public void displayTop() {
        libraryRepository.displayTop();
    }

    @Override
    public void search() {
        int temp= LibraryView.displaySearch();
        libraryRepository.search(temp);
    }
}
