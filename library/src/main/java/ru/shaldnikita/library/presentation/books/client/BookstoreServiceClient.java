package ru.shaldnikita.library.presentation.books.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shaldnikita.library.application.book.BookModel;


/**
 * @author n.shaldenkov on 18.09.2018
 */

@FeignClient(name = "bookstore", url = "${bookstore-service:}")
public interface BookstoreServiceClient  {

    @GetMapping("/books")
    Page<BookModel> getBooks(PageRequest pageable);

}
