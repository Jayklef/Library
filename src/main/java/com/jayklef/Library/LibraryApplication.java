package com.jayklef.Library;

import com.jayklef.Library.entity.Author;
import com.jayklef.Library.entity.Book;
import com.jayklef.Library.entity.Category;
import com.jayklef.Library.entity.Publisher;
import com.jayklef.Library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) -> {
			Book book1 = new Book("ABC", "Book Name", "My first book");
			Publisher publisher1 = new Publisher("First Publisher");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC1", "Book name", "My first book");
			Author author2 = new Author("Test name2", "Test description");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second Publisher");
			book1.addAuthor(author2);
			book1.addCategory(category2);
			book1.addPublisher(publisher2);
			bookService.createBook(book2);


			Book book3 = new Book("ABC1", "Book name", "My first book");
			Author author3 = new Author("Test name2", "Test description");
			Category category3 = new Category("Science books");
			Publisher publisher3 = new Publisher("Second Publisher");
			book1.addAuthor(author3);
			book1.addCategory(category3);
			book1.addPublisher(publisher3);
			bookService.createBook(book3);
		};
	}

}
