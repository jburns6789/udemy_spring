package udemy.burns.udemy_spring.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.burns.udemy_spring.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
