package udemy.burns.udemy_spring.repositories;

import udemy.burns.udemy_spring.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
