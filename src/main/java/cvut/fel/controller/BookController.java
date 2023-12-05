package cvut.fel.controller;

import cvut.fel.dto.BookDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.model.Book;
import cvut.fel.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    private final BookServiceImp bookService;
    private final DTOMapper dtoMapper;

    @Autowired
    public BookController(BookServiceImp bookService, DTOMapper dtoMapper) {
        this.bookService = bookService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        BookDTO bookDTO = dtoMapper.bookToDto(book);
        return ResponseEntity.ok(bookDTO);
    }

}
