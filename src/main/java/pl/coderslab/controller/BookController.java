package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

// RestController od razu tworzy ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {

    /*
    GET	/books/ Zwraca listę wszystkich książek.
    POST /books/ Tworzy nową książkę na podstawie danych przekazanych z formularza i zapisuje ją do bazy danych.
    GET /books/{id} Wyświetla informacje o książce o podanym id.
    PUT /books/{id} Zmienia informacje o książce o podanym id na nową.
    DELETE /books/{id} Usuwa książkę o podanym id z bazy danych.
    */

    MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
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

    @PostMapping
    public String createBook() {
        return "TODO: createBook";
    }
    @PostMapping("/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
    public String addNewBook(@PathVariable Long id, @PathVariable String isbn,
                             @PathVariable String title, @PathVariable String author,
                             @PathVariable String publisher, @PathVariable String type) {
        memoryBookService.addNewBook(id, isbn, title, author, publisher, type);
        return "Added new book: " + title + " by " + author;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return  "TODO: deleteBook " + id;
    }
    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id) {
        return "TODO: updateBook " + id;
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }
}
