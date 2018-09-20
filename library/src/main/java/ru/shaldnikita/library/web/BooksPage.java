package ru.shaldnikita.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shaldnikita.library.presentation.books.client.BookstoreServiceClient;

import javax.annotation.PostConstruct;

/**
 * @author n.shaldenkov on 18.09.2018
 */
//@Route("books")
@Component
public class BooksPage /*extends Div*/ {

    @Autowired
    private BookstoreServiceClient bookstoreServiceClient;

    @PostConstruct
    private void init() {
       /* Grid<BookModel> grid = new Grid<>(BookModel.class);
        //grid.setItems(bookstoreServiceClient.getBooks(PageRequest.of(0, 10)).getContent());
        add(grid)*/
        ;
    }
}

