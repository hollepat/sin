package cvut.fel.service;

import cvut.fel.model.Book;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;


public class BookServiceImp implements BookService{

    Logger logger = Logger.getLogger(BookServiceImp.class.getName());

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

        logger.setLevel(Level.FINE);
    }

    public Book findById(Long id){

        if (id == null) {
            logger.log(Level.WARNING, "Id is not valid, id: " + id);
            throw new FieldMissingException();
        }
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

}
