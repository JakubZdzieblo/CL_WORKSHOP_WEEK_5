package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

// RestController od razu tworzy ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService memoryBookService;

    @Autowired
    public BookController(BookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }
    @GetMapping
    public List<Book> getBooks() {
        return memoryBookService.getList();
    }
    @GetMapping("/{id}")
    public Book getBooksById(@PathVariable Long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping("/{id}")
    public String createBook(@PathVariable Long id, @RequestParam String isbn,
                             @RequestParam String title, @RequestParam String author,
                             @RequestParam String publisher, @RequestParam String type) {
        memoryBookService.addNewBook(id, isbn, title, author, publisher, type);
        return "Added new book: " + title + " by " + author;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        memoryBookService.deleteBook(id);
        return  "deleted Book ID: " + id;
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestParam (required = false) String isbn,
                             @RequestParam (required = false) String title, @RequestParam (required = false) String author,
                             @RequestParam (required = false) String publisher, @RequestParam (required = false) String type) {
        memoryBookService.updateBook(id, isbn, title, author, publisher, type);
        return "Updated Book ID: " + id;
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }
}
