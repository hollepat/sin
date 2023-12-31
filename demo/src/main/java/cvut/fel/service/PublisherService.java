package cvut.fel.service;

import cvut.fel.entity.Publisher;

public interface PublisherService {
    boolean createContract(Long authorId, Long publisherId);
    boolean publishBook(Long publisherId, Long bookId);

    Publisher findById(Long publisherId);
}
