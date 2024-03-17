package com.k8sone.k8sonedemoone.controller;

import com.k8sone.k8sonedemoone.K8sonedemooneApplication;
import com.k8sone.k8sonedemoone.model.Book;
import com.k8sone.k8sonedemoone.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    private final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        LOGGER.info("books.findAll()");
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        LOGGER.info("findById : {}", id);
        return bookService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Book create(@RequestBody Book book) {
        LOGGER.info("create : {}", book);
        return bookService.save(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        LOGGER.info("update : {}", book);
        return bookService.save(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        LOGGER.info("deleteById : {}", id);
        bookService.deleteById(id);
    }

}
