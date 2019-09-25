package ke.co.tracom.controller;

import ke.co.tracom.Entity.Book;
import ke.co.tracom.Entity.BookUpdatePayload;
import ke.co.tracom.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    //defining book service
    private BookService bookService;

    //method to get em books
    @GetMapping
    public Collection<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public Book postBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping(value = "/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<Book> deleteBookById(@PathVariable("id") int id) {
        return bookService.deleteBookById(id);
    }

    @PutMapping(value = "/{id}")
    public Optional<Book> updateBookById(@PathVariable("id") int id, @RequestBody BookUpdatePayload
            bookUpdatePayload) {
        return bookService.updateBookById(id, bookUpdatePayload);
    }
}
