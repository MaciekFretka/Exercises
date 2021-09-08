package pl.mj.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mj.books.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
