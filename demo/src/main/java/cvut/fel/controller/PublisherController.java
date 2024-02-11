package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.PublisherDTO;
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
    @PostMapping("/publisher/{publisherId}/book/{bookId}")
    public boolean publishBook(@PathVariable Long bookId, @PathVariable Long publisherId) {
        return publisherService.publishBook(publisherId, bookId);
    }

    @GetMapping("/publisher/{publisherId}")
    public ResponseEntity<PublisherDTO> findPublisherById(@PathVariable Long publisherId) {
        return ResponseEntity.ok(dtoMapper.publisherToDto(publisherService.findById(publisherId)));
    }


}
