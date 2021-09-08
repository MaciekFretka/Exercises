package pl.mj.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mj.books.repo.AuthorDto;
import pl.mj.books.repo.AuthorRepo;

import java.util.List;

@RestController
public class AuthorRestApi {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorRestApi(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/getAuthorInfo")
    public List<AuthorDto> get(){
        return authorRepo.getCategoryCount();
    }
}
