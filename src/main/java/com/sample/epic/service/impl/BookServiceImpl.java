package com.sample.epic.service.impl;

import com.sample.epic.domain.Book;
import com.sample.epic.dto.request.BookDTO;
import com.sample.epic.repository.BookRepository;
import com.sample.epic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(@Valid BookDTO bookDTO) {
        return bookRepository.save(bookDTO);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(BookDTO bookDTO) {
        return bookRepository.update(bookDTO);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}
