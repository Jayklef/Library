package com.jayklef.Library.service;

import com.jayklef.Library.entity.Book;
import com.jayklef.Library.repository.BookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not Found"));
        return book;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not Found"));
        bookRepository.deleteById(book.getId());
    }
}
