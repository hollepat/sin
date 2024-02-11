package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.LibraryDTO;
import cvut.fel.service.LibraryServiceImpl;
import io.swagger.models.Response;
import org.apache.tomcat.jni.Library;
import org.apache.tomcat.jni.LibraryNotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

    private final LibraryServiceImpl libraryService;

    @Autowired
    public LibraryController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    /*
     * Controller has methods corresponding to in services methods.
     */

    @PostMapping("/addBook/{bookId}/toLibrary/{libraryId}")
    public boolean addBookToLibrary(@PathVariable Long bookId, @PathVariable Long libraryId) {
        return libraryService.addBookToLibrary(bookId, libraryId);
    }


    @PostMapping("/create-library")
    public ResponseEntity<Boolean> createLibrary(@RequestBody LibraryDTO libraryDTO) {
        System.out.println("Creating new library: " + libraryDTO);
        return ResponseEntity.ok(libraryService.createLibrary(libraryDTO));
    }

}
