package cvut.fel.repository;

import cvut.fel.entity.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
