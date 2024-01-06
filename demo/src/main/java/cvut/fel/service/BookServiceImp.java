package cvut.fel.service;

import cvut.fel.dto.BookDTO;
import cvut.fel.entity.Author;
import cvut.fel.entity.Book;

import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;
    Logger logger = Logger.getLogger(BookServiceImp.class.getName());

    @Autowired
    public BookServiceImp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Cacheable(value = "booksCache", key = "#id")
    public Book findById(Long id){

        if (id == null) {
            logger.log(Level.WARNING, "Id is not valid, id: " + id);
            throw new FieldMissingException();
        }
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

    @Cacheable(value = "booksCache", key = "#bookDTO.id")
    public Boolean createBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            logger.log(Level.WARNING, "BookDTO is not valid");
            throw new FieldMissingException();
        }
        logger.log(Level.INFO, "Creating new book: " + bookDTO);
        Book newBook = new Book(bookDTO.getName());
        newBook.setISBN(bookDTO.getISBN());
        newBook.setPublisher(null);
        List<Author> authorList = new ArrayList<>();
        for (Long authorId : bookDTO.getAuthorsIds()) {
            authorList.add(authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("AUTHOR_NOT_FOUND")));
        }
        newBook.setAuthors(authorList);
        logger.log(Level.INFO, "Creating new book: " + newBook);
        bookRepository.save(newBook);
        return true;
    }
}
