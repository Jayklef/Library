package com.jayklef.Library.service;

import com.jayklef.Library.entity.Author;
import com.jayklef.Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author with id: " + id + "not found"));
        return author;
    }

    public void deleteAuthor(Long id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author with id of " +id + "not found"));
        authorRepository.deleteById(author.getId());
    }
}
