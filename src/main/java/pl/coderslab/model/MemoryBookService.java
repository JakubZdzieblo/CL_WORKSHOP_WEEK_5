package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public Book getBookById(long id) {

        Book foundBook = new Book();
        for (Book book : list) {
            if (book.getId() == id) {
                foundBook = book;
            }
        }

        return foundBook;
    }

    public void addNewBook(Long id, String isbn, String title, String author, String publisher, String type) {
        Book book = new Book(id, isbn, title, author, publisher, type);
        list.add(book);
    }

    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}

}
