package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author sameera = new Author("Sameera", "Reddy");
        Book killingAnimals = new Book("Killing animals", "12321");
        sameera.getBooks().add(killingAnimals);
        killingAnimals.getAuthors().add(sameera);
        Publisher publisher = new Publisher("Sanjay Dutt", "plot number 123", "kanpur", "UP", "209098");

        bookRepository.save(killingAnimals);
        authorRepository.save(sameera);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publishers " + publisherRepository.count());

    }
}
