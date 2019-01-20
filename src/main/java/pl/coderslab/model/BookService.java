package pl.coderslab.model;

import java.util.List;

public interface BookService {

    public Book getBookById(Long id);

    public void addNewBook(Long id, String isbn, String title, String author, String publisher, String type);

    public void updateBook(Long id, String isbn, String title, String author, String publisher, String type);

    public void deleteBook(Long id);

    public List<Book> getList();

    public void setList(List<Book> list);

}
