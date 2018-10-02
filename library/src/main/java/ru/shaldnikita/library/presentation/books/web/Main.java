package ru.shaldnikita.library.presentation.books.web;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.shaldnikita.library.application.book.BookModel;
import ru.shaldnikita.library.presentation.books.client.BookstoreServiceClient;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author n.shaldenkov on 26.09.2018
 */
@Route("")
@Service
@Scope("prototype")
public class Main extends Grid {

    private final BookstoreServiceClient bookstoreServiceClient;

    public Main(BookstoreServiceClient bookstoreServiceClient) {
        super(BookModel.class);
        this.bookstoreServiceClient = bookstoreServiceClient;

    }

    @PostConstruct
    private void init() {
        setSizeFull();
        List<BookModel> books = this.bookstoreServiceClient.getBooks();
        setDataProvider(new ListDataProvider<>(books));
    }
}