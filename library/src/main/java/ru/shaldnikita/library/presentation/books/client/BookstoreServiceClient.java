package ru.shaldnikita.library.presentation.books.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shaldnikita.library.application.book.BookModel;

import java.util.List;


/**
 * @author n.shaldenkov on 18.09.2018
 */

@FeignClient(name = "bookstore", url = "${bookstore-service:}")
public interface BookstoreServiceClient {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
        //todo replace with page
    List<BookModel> getBooks();

}
