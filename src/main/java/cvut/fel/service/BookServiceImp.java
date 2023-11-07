package cvut.fel.service;

import cvut.fel.model.Book;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;

public class BookServiceImp implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book findById(Long id){

        if (id == null)
            throw new FieldMissingException();
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

}
