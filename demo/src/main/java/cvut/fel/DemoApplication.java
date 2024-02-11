package cvut.fel;

import cvut.fel.entity.Genre;
import cvut.fel.entity.Library;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cvut.fel.entity.Book;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Hello world!");

		Book book = new Book("Harry Potter");
		book.setISBN("234234234");
		book.setPublisher(null);
		book.setGenre(Genre.FANTASY);

		bookRepository.save(book);

	}
}
