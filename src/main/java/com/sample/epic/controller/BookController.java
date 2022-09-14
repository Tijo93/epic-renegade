package com.sample.epic.controller;

import com.sample.epic.domain.Book;
import com.sample.epic.dto.request.BookDTO;
import com.sample.epic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping // http://localhost:8899/api/books/
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("{id}") //http://localhost:8899/api/books/n
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PostMapping // http://localhost:8899/api/books/
    public ResponseEntity<Book> saveBook(@RequestBody @Validated BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.saveBook(bookDTO));
    }

    @PutMapping // http://localhost:8899/api/books
    public ResponseEntity<Book> updateBook(@RequestBody @Validated BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(bookDTO));
    }

    @DeleteMapping("{id}") //http://localhost:8899/api/books/n
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
