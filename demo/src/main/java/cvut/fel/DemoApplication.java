package cvut.fel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cvut.fel.entity.Book;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Hello world!");



//		System.out.println("\nfindById(1L)");
//		bookRepository.findById(1L).ifPresent(System.out::println);
//
//		System.out.println("\nfindByName('Node')");
//		bookRepository.findByName("Node").forEach(System.out::println);

//		 service should be used instead of direct repository
//		 services wrap handling of data in dbs with extra logic
//		Book givenBook = bookService.findById(1L);
//		System.out.println(givenBook.toString());

	}
}
