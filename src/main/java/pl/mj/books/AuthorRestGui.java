package pl.mj.books;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.mj.books.repo.AuthorDto;
import pl.mj.books.repo.AuthorRepo;

import java.util.List;

@Route
public class AuthorRestGui extends VerticalLayout {

    private AuthorRepo authorRepo;

    public AuthorRestGui(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;

        List<AuthorDto> personList = authorRepo.getCategoryCount();

        Grid<AuthorDto> grid = new Grid<>(AuthorDto.class);
        grid.setItems(personList);
        add(grid);


    }

}
