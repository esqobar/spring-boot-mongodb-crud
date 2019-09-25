package ke.co.tracom.Service;

import ke.co.tracom.DAO.BookDAO;
import ke.co.tracom.Entity.Book;
import ke.co.tracom.Entity.BookUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    //defining bookDAO
    private BookDAO bookDAO;

    public Collection<Book>getBooks(){
        return bookDAO.getBooks();
    }

    public Book createBook(Book book) {
        return bookDAO.createBook(book);
    }

    public Optional<Book> getBookById(int id) {
        return bookDAO.getBookId(id);
    }

    public Optional<Book> deleteBookById(int id) {
        return bookDAO.deleteBookById(id);
    }

    public Optional<Book> updateBookById(int id, BookUpdatePayload bookUpdatePayload) {
        return bookDAO.updateBookById(id, bookUpdatePayload);
    }
}
