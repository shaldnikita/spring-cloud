package ru.shaldnikita.library.presentation.books.client;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import org.atmosphere.inject.annotation.RequestScoped;
import org.springframework.data.domain.PageRequest;
import ru.shaldnikita.library.application.book.BookModel;

import javax.annotation.PostConstruct;

/**
 * @author n.shaldenkov on 26.09.2018
 */
@Route("")
@RequestScoped
@RequiredArgsConstructor
public class Main extends Div {

    private final transient BookstoreServiceClient bookstoreServiceClient;

    @PostConstruct
    private void init() {
        Grid<BookModel> grid = new Grid<>(BookModel.class);
        grid.setItems(bookstoreServiceClient.getBooks(PageRequest.of(0, 10)).getContent());
    }
}
