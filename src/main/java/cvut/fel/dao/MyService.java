package cvut.fel.dao;
import cvut.fel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Optional<Library> findLibraryById(Long id) {
        return libraryRepository.findById(id);
    }

    public Library addLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibraryById(Long id) {
        libraryRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findPublisherById(Long id) {
        return publisherRepository.findById(id);
    }

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

}
