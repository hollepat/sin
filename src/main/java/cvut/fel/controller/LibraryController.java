package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.service.LibraryServiceImpl;
import org.apache.tomcat.jni.Library;
import org.apache.tomcat.jni.LibraryNotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    private final LibraryServiceImpl libraryService;

    private final DTOMapper dtoMapper;

    @Autowired
    public LibraryController(LibraryServiceImpl libraryService, DTOMapper dtoMapper) {
        this.libraryService = libraryService;
        this.dtoMapper = dtoMapper;
    }

    /*
     * Controller has methods corresponding to in services methods.
     */

    @PostMapping("/library/{libraryId}/book/{bookId}")
    public boolean addBookToLibrary(@PathVariable Long bookId, @PathVariable Long libraryId) {
        return libraryService.addBookToLibrary(bookId, libraryId);
    }

}
