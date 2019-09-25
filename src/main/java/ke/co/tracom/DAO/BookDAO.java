package ke.co.tracom.DAO;

import ke.co.tracom.Entity.Book;
import ke.co.tracom.Entity.BookUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class BookDAO {

    @Autowired
    //defining a repository
    private BookRepository repository;

    //method to create a collection
    public Collection<Book>getBooks(){
        return repository.findAll();
    }

    public Book createBook(Book book) {
        return repository.insert(book);
    }

    public Optional<Book> getBookId(int id) {
        return repository.findById(id);
    }

    public Optional<Book> deleteBookById(int id) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b -> repository.delete(b));
        return book;
    }

    public Optional<Book> updateBookById(int id, BookUpdatePayload bookUpdatePayload) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b ->b.setTitle(bookUpdatePayload.getTitle()));
        book.ifPresent(b ->b.setAuthor(bookUpdatePayload.getAuthor()));
        book.ifPresent(b -> repository.save(b));
        return book;
    }
}
