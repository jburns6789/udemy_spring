package udemy.burns.udemy_spring.bootStrap;

import udemy.burns.udemy_spring.model.Author;
import udemy.burns.udemy_spring.model.Book;
import udemy.burns.udemy_spring.model.Publisher;
import udemy.burns.udemy_spring.repositories.AuthorRepository;
import udemy.burns.udemy_spring.repositories.BookRepository;
import udemy.burns.udemy_spring.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//spring will look for this and run it if found
@Component //tell spring to detect as a component
public class bootStrapData implements CommandLineRunner {
        //Major focus on database mapping and annotations for jpa, hibernate is writing the code
        //behind the scenes for the database queries
        //creating entities and being stored in a H2 database watch publisher relations 18
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public bootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("Florida");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book programming = new Book("Dont Give Up", "456789");

        eric.getBooks().add(programming);
        programming.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(programming);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development w/o  EJ8", "789456");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
