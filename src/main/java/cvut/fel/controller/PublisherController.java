package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.service.PublisherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublisherController {

    private final PublisherServiceImp publisherService;

    private final DTOMapper dtoMapper;

    @Autowired
    public PublisherController(PublisherServiceImp publisherService, DTOMapper dtoMapper) {
        this.publisherService = publisherService;
        this.dtoMapper = dtoMapper;
    }

    // .../publisher/crateContract?authorId=1&publisherId=1
    @PostMapping("/publisher/createContract")
    public boolean createContract(@RequestParam Long authorId, @RequestParam Long publisherId) {
        return publisherService.createContract(authorId, publisherId);
    }

    // .../publisher/1/book/1
    @PostMapping("/publisher/{libraryId}/book/{bookId}")
    public boolean publishBook(@PathVariable Long bookId, @PathVariable Long libraryId) {
        return publisherService.publishBook(bookId, libraryId);
    }


}
