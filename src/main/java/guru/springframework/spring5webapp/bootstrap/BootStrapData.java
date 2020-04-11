package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author sameera = new Author("Sameera", "Reddy");
        Book killingAnimals = new Book("Killing animals", "12321");
        sameera.getBooks().add(killingAnimals);
        killingAnimals.getAuthors().add(sameera);

        bookRepository.save(killingAnimals);
        authorRepository.save(sameera);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());



    }
}
