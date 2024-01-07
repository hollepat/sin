package cvut.fel.database;

import cvut.fel.entity.Author;
import cvut.fel.entity.Book;
import cvut.fel.entity.Genre;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Test
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

        List<Book> books = (List<Book>) bookRepository.findAll();

        System.out.println("\nfindAll()");
        books.forEach(System.out::println);

        assertEquals(book1.getName(), books.get(0).getName());
        assertEquals(book1.getGenre(), books.get(0).getGenre());
        assertEquals(book2.getName(), books.get(1).getName());
        assertEquals(book2.getGenre(), books.get(1).getGenre());
        assertEquals(book3.getName(), books.get(2).getName());
        assertEquals(book3.getGenre(), books.get(2).getGenre());

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
}
