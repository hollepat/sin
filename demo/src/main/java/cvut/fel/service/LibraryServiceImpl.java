package cvut.fel.service;

import cvut.fel.exception.FieldInvalidException;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.entity.Book;
import cvut.fel.entity.Library;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public boolean addBookToLibrary(Long bookId, Long libraryId) {

        // fetch book
        if (bookId == null) {
            logger.log(Level.WARNING, "Id is not valid" );
            throw new FieldMissingException();
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));

        // fetch library
        if (libraryId == null) {
            logger.log(Level.WARNING, "Id is not valid");
            throw new FieldMissingException();
        }
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new NotFoundException("LIBRARY_NOT_FOUND"));

        // check if book already in library
        if (book.getLibrary() != null) {
            logger.log(Level.FINE, "Book " + book + " is in the Library " + book.getLibrary());
            throw new FieldInvalidException("BOOK_ALREADY_IN_LIBRARY");
        }

        book.setLibrary(library);

        bookRepository.save(book);

        return true;
    }
}
