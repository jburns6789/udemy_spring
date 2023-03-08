package udemy.burns.udemy_spring.repositories;

import udemy.burns.udemy_spring.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

//Spring data jpa, intended to work with hibernate, repository pattern, DAO jdbc simplification
//
