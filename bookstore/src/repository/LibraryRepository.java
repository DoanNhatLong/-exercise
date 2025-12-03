package repository;

import entity.Book;
import entity.Magazine;
import entity.Publication;
import ulitity.Helper;
import ulitity.Library;
import ulitity.ReadAndWriteFile;

import java.util.*;

import static ulitity.Helper.inputInt;
import static ulitity.Helper.inputString;

public class LibraryRepository implements ILibraryRepository {
    public static final String LIBRARY_LIST = "src/data/library.csv";


    @Override
    public void addBook(Book temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(LIBRARY_LIST, stringList, true);
    }

    @Override
    public void addMagazine(Magazine temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(LIBRARY_LIST, stringList, true);
    }

    @Override
    public void display() {
        for (Publication publication : getAll()) {
            System.out.println(publication);
        }
    }

    @Override
    public void addAuthor() {
        String name = inputString("Nhập tên sách muốn thêm tác giả");
        List<Publication> publicationList = getAll();
        List<String> stringList = new ArrayList<>();
        for (Publication publication : publicationList) {
            if (publication instanceof Book) {
                if (Objects.equals(publication.getName(), name)) {
                    String author = inputString("Nhập tên tác giả muốn thêm vào");
                    if (((Book) publication).getAuthor().contains(author)) {
                        System.out.println("Tác giả đã có");
                    } else {
                        ((Book) publication).setAuthor(((Book) publication).getAuthor() + "&" + author);
                        System.out.println("Đã thêm thành công");
                    }
                }
            }
        }
        for (Publication publication : publicationList) {
            stringList.add(publication.toCSV());
        }
        ReadAndWriteFile.write(LIBRARY_LIST, stringList, false);
    }

    @Override
    public void displayTop() {
        List<Magazine> magazineList = new ArrayList<>();
        for (Publication publication : getAll()) {
            if (publication instanceof Magazine) {
                magazineList.add((Magazine) publication);
            }
        }
        magazineList.sort(Comparator
                .comparing(Magazine::getVolume)
                .reversed());
        for (int i = 0; i < Math.min(3, magazineList.size()); i++) {
            System.out.println(magazineList.get(i));
        }
    }

    @Override
    public void search(int temp) {
        List<Publication> publicationList = getAll();
        List<Book> bookList = new ArrayList<>();
        for (Publication publication : publicationList) {
            if (publication instanceof Book) {
                bookList.add((Book) publication);
            }
        }
        switch (temp) {
            case 1 -> {
                String isbn = inputString("Nhập mã isbn muốn tìm");
                for (Book book : bookList) {
                    if (book.getIsbn().contains(isbn)) {
                        System.out.println(book);
                    }
                }
            }
            case 2 -> {
                String name = inputString("Nhập tên muốn tìm");
                for (Book book : bookList) {
                    if (book.getName().contains(name)) {
                        System.out.println(book);
                    }
                }
            }
            case 3 -> {
                int year = inputInt("Nhập năm muốn tìm");
                for (Book book : bookList) {
                    if (book.getYear() <= year) {
                        System.out.println(book);
                    }
                }
            }
        }
    }

    @Override
    public List<Publication> getAll() {
        return Library.getAll(
                LIBRARY_LIST,
                Map.of(
                        "Book", arr -> new Book(Integer.parseInt(arr[1]), arr[2], arr[3], arr[4], arr[5]),
                        "Magazine", arr -> new Magazine(Integer.parseInt(arr[1]), arr[2], arr[3], arr[4], Integer.parseInt(arr[5]))
                )
        );
    }
}
