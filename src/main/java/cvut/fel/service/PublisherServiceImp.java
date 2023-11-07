package cvut.fel.service;

import cvut.fel.exception.FieldInvalidException;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.model.Author;
import cvut.fel.model.Publisher;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublisherServiceImp {

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public PublisherServiceImp(PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    public boolean createContract(Long authorId, Long publisherId) {

        // find author
        if (authorId == null) {
            throw new FieldMissingException();
        }
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException("AUTHOR_NOT_FOUND"));

        // find publisher
        if (publisherId == null) {
            throw new FieldMissingException();
        }
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new NotFoundException("PUBLISHER_NOT_FOUND"));

        // check if not already assigned
        List<Author> authors = publisher.getContracts();
        List<Publisher> publishers = author.getPublishers();

        // check if already assigned
        if (authors.contains(author))
            throw new FieldInvalidException("AUTHOR_ALREADY_IN_PUBLISHERS_LIST");
        if (publishers.contains(publisher))
            throw new FieldInvalidException("PUBLISHER_ALREADY_IN_AUTHORS_LIST");

        // add publisher and author
        authors.add(author);
        publishers.add(publisher);

        authorRepository.save(author);
        publisherRepository.save(publisher);

        return true;
    }
}
