package cvut.fel.service;

import cvut.fel.exception.FieldInvalidException;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.entity.Book;
import cvut.fel.entity.Library;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LibraryServiceImpl implements LibraryService{

    LibraryRepository libraryRepository;
    BookRepository bookRepository;

    Logger logger = Logger.getLogger(LibraryServiceImpl.class.getName());

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    @Cacheable(value = "librariesCache", key = "#libraryId")
    public boolean addBookToLibrary(Long bookId, Long libraryId) {

        // fetch book
        if (bookId == null) {
            logger.log(Level.WARNING, "Id is not valid, bookId: " + bookId);
            throw new FieldMissingException();
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));

        // fetch library
        if (libraryId == null) {
            logger.log(Level.WARNING, "Id is not valid, libraryId: " + libraryId);
            throw new FieldMissingException();
        }
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new NotFoundException("LIBRARY_NOT_FOUND"));

        // check if book already in library
        if (library.containsBook(book)) {
            logger.log(Level.FINE, "Book " + book.toString() + " is in the Library " + library.toString());
            throw new FieldInvalidException("BOOK_ALREADY_IN_LIBRARY");
        }

        // add book to library
        library.addBook(book);

        libraryRepository.save(library);

        return true;
    }
}
