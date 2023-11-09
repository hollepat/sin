package cvut.fel.service;

import cvut.fel.exception.FieldInvalidException;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.model.Author;
import cvut.fel.model.Book;
import cvut.fel.model.Publisher;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublisherServiceImp implements PublisherService{

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    /*
    @Autowired is a dependency injection, which creates repositories
    for us so programmer do not have to do it manually (e.g. in the main).
     */
    @Autowired
    public PublisherServiceImp(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

    public boolean publishBook(Long publisherId, Long bookId) {

        // fetch publisher
        if (publisherId == null) {
            throw new FieldMissingException();
        }
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new NotFoundException("PUBLISHER_NOT_FOUND"));

        // fetch book
        if (bookId == null) {
            throw new FieldMissingException();
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));

        // validate book hasn't been published
        if (book.getPublisher() != null) {
            throw new FieldInvalidException("BOOK_ALREADY_PUBLISHED");
        }

        // Authors have Contract with publisher
        List<Author> authors = book.getAuthors();
        for (Author a : authors) {
            if (! a.hasContractWithPublisher(publisher)) { throw new FieldInvalidException("AUTHOR_DOESN'T_HAVE_CONTRACT_WITH_PUBLISHER"); }
        }

        // assign book to publisher
        publisher.addPublishedBook(book);

        // assign publisher to book
        book.setPublisher(publisher);

        // save
        publisherRepository.save(publisher);
        bookRepository.save(book);

        return true;
    }
}
