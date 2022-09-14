package com.sample.epic.repository;

import com.sample.epic.domain.Book;
import com.sample.epic.dto.request.BookDTO;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private final List<Book> list = new ArrayList<>() {{
        add(new Book(1L, "Effective Java", "Steve"));
        add(new Book(2L, "Book 2", "Jinu"));
        add(new Book(3L, "Book 3", "John"));
    }};

    public List<Book> getAllBooks() {
        return list;
    }

    public Book findById(Long id) {
        for (Book book : list) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> search(String name) {
        return list.stream().filter(x -> x.getTitle().startsWith(name)).collect(Collectors.toList());
    }

    public Book save(@Valid BookDTO p) {
        Book book = new Book();
        book.setId(p.getId());
        book.setTitle(p.getTitle());
        book.setAuthor(p.getAuthor());
        list.add(book);
        return book;
    }

    public String delete(Long id) {
        list.removeIf(x -> Objects.equals(x.getId(), id));
        return null;
    }

    public Book update(@Valid BookDTO bookDTO) {
        int idx = 0;
        long id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), bookDTO.getId())) {
                id = bookDTO.getId();
                idx = i;
                break;
            }
        }

        Book book = new Book();
        book.setId(id);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        list.set(idx, book);
        return book;
    }
}
