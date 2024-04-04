package com.maids.backend.services;

import com.maids.backend.models.Book;
import com.maids.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById (Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook (Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook (Long id, Book bookDetail) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDetail.getTitle());
        book.setAuthor(bookDetail.getAuthor());
        book.setPublicationYear(bookDetail.getPublicationYear());
        book.setIsbn(bookDetail.getIsbn());

        return bookRepository.save(book);
    }

    public void deteleBook (Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }
}
