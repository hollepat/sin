package cvut.fel.database;

import cvut.fel.entity.*;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.LibraryRepository;
import cvut.fel.repository.PublisherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class DatabaseTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private PublisherRepository publisherRepository;


    @Test
    @Commit
    public void createThreeBooks() {
        Book book1 = new Book("Java");
        book1.setISBN("1");
        book1.setGenre(Genre.FANTASY);
        Book book2 = new Book("Node");
        book2.setISBN("2");
        Book book3 = new Book("Python");
        book3.setGenre(Genre.HORROR);
        book3.setISBN("3");

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        Book getBook1 = bookRepository.findByName("Java");

        System.out.println("\nfindAll()");
        bookRepository.findAll().forEach(System.out::println);

        assertEquals(book1.getName(), getBook1.getName());
        assertEquals(book1.getGenre(), getBook1.getGenre());

    }

    @Test
    @Commit
    public void createBookAndAuthor() {

        Author author = new Author("John");
        author.setEmail("john@gmail.com");

        List<Author> authors = new ArrayList<>();
        authors.add(author);

        Book book = new Book("JS");
        book.setISBN("4");
        book.setGenre(Genre.FANTASY);
        book.setAuthors(authors);

        List<Book> books = new ArrayList<>();
        books.add(book);

        author.setBooks(books);

        bookRepository.save(book);
        authorRepository.save(author);

    }

    @Test
    @Commit
    public void createAll() {
        Library library = new Library("KnihyDub");
        library.setAddress(new Address("Praha", "Zakova", "43534"));

        Author author = new Author("John");
        author.setEmail("john@gmail.com");

        Book book = new Book("PHP");
        book.setISBN("5");
        book.setGenre(Genre.FANTASY);
        book.setAuthors(Arrays.asList(author));
        book.setLibrary(library);

        author.setBooks(Arrays.asList(book));

        Publisher publisher = new Publisher("ABC");
        publisher.setAddress(new Address("Praha", "Sezamova", "12345"));
        publisher.setContracts(Arrays.asList(author));
        publisher.setPublishedBooks(Arrays.asList(book));

        author.setPublishers(Arrays.asList(publisher));
        book.setPublisher(publisher);

        bookRepository.save(book);
        authorRepository.save(author);
        publisherRepository.save(publisher);
        libraryRepository.save(library);

    }

}
