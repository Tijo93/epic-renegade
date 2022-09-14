package com.sample.epic.service;

import com.sample.epic.domain.Book;
import com.sample.epic.dto.request.BookDTO;

import java.util.List;

public interface BookService {

    Book saveBook(BookDTO bookDTO);

    List<Book> getBooks();

    Book getBook(Long id);

    Book updateBook(BookDTO bookDTO);

    void deleteBook(Long id);
}
