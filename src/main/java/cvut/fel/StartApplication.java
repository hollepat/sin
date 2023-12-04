package cvut.fel;

import cvut.fel.model.Book;
import cvut.fel.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Book book1 = new Book();
        book1.setISBN(1L);
        Book book2 = new Book();
        book2.setISBN(2L);
        Book book3 = new Book();
        book3.setISBN(3L);
        bookRepository.save(book1);

        System.out.println("\nfindAll()");
        bookRepository.findAll().forEach(System.out::println);

        System.out.println("\nfindById(1L)");
        bookRepository.findById(1L).ifPresent(System.out::println);

        System.out.println("\nfindByName('Node')");
        bookRepository.findByName("Node").forEach(System.out::println);


    }

}