package cvut.fel.controller;

import cvut.fel.dto.BookDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookController {

    /*
    * In the context of software architecture, a controller is a crucial
    * component responsible for handling incoming requests, processing
    * them, and providing responses. It's a part of the MVC (Model-View-Controller)
    * or similar architectural patterns.
    * */

    private final BookService bookService;
    private final DTOMapper dtoMapper;

    @Autowired
    public BookController(BookService bookService, DTOMapper dtoMapper) {
        this.bookService = bookService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.bookToDto(bookService.findById(id)));
    }

    @PostMapping("/new-book")
    public ResponseEntity<Boolean> createBook(@RequestBody BookDTO bookDTO) {
        System.out.println("Creating new book: " + bookDTO.toString());
        return ResponseEntity.ok(bookService.createBook(bookDTO)); // TODO: create function in service
    }

}
