package cvut.fel;

import cvut.fel.repository.BookRepository;
import cvut.fel.service.BookService;
import cvut.fel.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cvut.fel.entity.Book;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookServiceImp bookService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello world!");

//		Book book1 = new Book("Java");
//		book1.setISBN("1");
//		Book book2 = new Book("Node");
//		book2.setISBN("2");
//		Book book3 = new Book("Python");
//		book3.setISBN("3");
//
//		bookRepository.save(book1);
//		bookRepository.save(book2);
//		bookRepository.save(book3);
//
//		System.out.println("\nfindAll()");
//		bookRepository.findAll().forEach(System.out::println);
//
//		System.out.println("\nfindById(1L)");
//		bookRepository.findById(1L).ifPresent(System.out::println);
//
//		System.out.println("\nfindByName('Node')");
//		bookRepository.findByName("Node").forEach(System.out::println);
//
//		// service should be used instead of direct repository
//		// services wrap handling of data in dbs with extra logic
//		Book givenBook = bookService.findById(1L);
//		System.out.println(givenBook.toString());

	}
}
