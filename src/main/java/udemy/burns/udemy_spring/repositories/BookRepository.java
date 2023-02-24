package udemy.burns.udemy_spring.repositories;

import udemy.burns.udemy_spring.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
