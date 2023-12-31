package cvut.fel.service;

import cvut.fel.dto.BookDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.entity.Book;

import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    private final DTOMapper dtoMapper;
    Logger logger = Logger.getLogger(BookServiceImp.class.getName());

    @Autowired
    public BookServiceImp(BookRepository bookRepository, DTOMapper dtoMapper) {
        this.bookRepository = bookRepository;
        this.dtoMapper = dtoMapper;
    }

    public Book findById(Long id){

        if (id == null) {
            logger.log(Level.WARNING, "Id is not valid, id: " + id);
            throw new FieldMissingException();
        }
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

    public Boolean createBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            logger.log(Level.WARNING, "BookDTO is not valid");
            throw new FieldMissingException();
        }
        logger.log(Level.INFO, "Creating new book: " + bookDTO.toString());
        Book newBook = dtoMapper.dtoToBook(bookDTO);
        newBook.setPublisher(null);
        logger.log(Level.INFO, "Creating new book: " + newBook.toString());
        bookRepository.save(newBook);
        return true;
    }
}
