package pl.coderslab.controller;


import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;

// RestController od razu tworzy ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }
    @GetMapping
    public String getBooks() {
        return "TODO: getBooks";
    }
    @PostMapping
    public String createBook() {
        return "TODO: createBook";
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
