package pl.mj.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mj.books.entity.Author;
import pl.mj.books.entity.Book;
import pl.mj.books.entity.BookCategory;
import pl.mj.books.repo.AuthorRepo;
import pl.mj.books.repo.BookRepo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Start {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    @Autowired
    public Start(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;



        Book book = new Book();
        book.setBookCategory(BookCategory.HORROR);
        book.setTitle("przygody małej myszki");
        book.setIsbn("2dwa2-dad23232");

        Book book2 = new Book();
        book2.setBookCategory(BookCategory.HORROR);
        book2.setTitle("przygody małego jeżyka");
        book2.setIsbn("2dwa2-dad23232");

        Book book3 = new Book();
        book3.setBookCategory(BookCategory.MEMOIR);
        book3.setTitle("przygody małej krówki ");
        book3.setIsbn("2dwa2-dad23232");

        Author author = new Author();
        author.setName("maciek");
        author.setSurname("jaroński");

        author.setBookSet(Stream.of(book,book2,book3).collect(Collectors.toSet()));
        bookRepo.save(book);
        bookRepo.save(book2);
        bookRepo.save(book3);
        authorRepo.save(author);




    }
}
