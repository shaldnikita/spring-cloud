package ru.shaldnikita.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import ru.shaldnikita.bookstore.application.author.AuthorService;
import ru.shaldnikita.bookstore.application.author.model.CreateAuthorModel;
import ru.shaldnikita.bookstore.application.book.BookService;
import ru.shaldnikita.bookstore.application.book.model.CreateBookModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CostsServiceApplication {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(CostsServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> IntStream.range(1, 12)
                .boxed()
                .map(i -> new CreateAuthorModel("Author" + i, LocalDate.of(1990 + i, i, i)))
                .map(this.authorService::createAuthor)
                .map(author -> new CreateBookModel(
                        "book" + new Random().nextInt(1000),
                        BigDecimal.valueOf(new Random().nextInt(1000)),
                        author.getAuthorId()))
                .forEach(this.bookService::createBook);
    }

}