package ru.shaldnikita.library.presentation.books.web;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.shaldnikita.library.application.book.BookModel;
import ru.shaldnikita.library.presentation.books.client.BookstoreServiceClient;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author n.shaldenkov on 26.09.2018
 */
@Route("")
@RequiredArgsConstructor
@Service
@Scope("prototype")
public class Main extends Div {

    private final BookstoreServiceClient bookstoreServiceClient;

    @PostConstruct
    private void init() {
        setWidth("1000px");
        setHeight("1000px");
        List<BookModel> books = bookstoreServiceClient.getBooks();
        setText(books.stream()
                .map(BookModel::toString)
                .collect(Collectors.joining("\n")));
    }
}