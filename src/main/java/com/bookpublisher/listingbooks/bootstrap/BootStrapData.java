package com.bookpublisher.listingbooks.bootstrap;

import com.bookpublisher.listingbooks.domain.Author;
import com.bookpublisher.listingbooks.domain.Book;
import com.bookpublisher.listingbooks.domain.Publisher;
import com.bookpublisher.listingbooks.repositories.AuthorRepository;
import com.bookpublisher.listingbooks.repositories.BookRepository;
import com.bookpublisher.listingbooks.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*
CommandLineRunner is an interface used to indicate that a bean should run when it is contained within
a SpringApplication. A Spring Boot application can have multiple beans implementing CommandLineRunner.
These can be ordered with @Order. **/
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    private static Logger logger = LoggerFactory.getLogger(BootStrapData.class);

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrapping in progress");
//        logger.info("BootStrapping in progress");
//
        Publisher publisherOne = new Publisher();
        publisherOne.setName("Publisher-One");
        publisherOne.setAddress("204 Rd");
        publisherOne.setCity("Bournemouth");
        publisherRepository.save(publisherOne);

        Author steve  = new Author();
        steve.setFirstName("Steve");
        steve.setLastName("Smith");

        Book bookOne = new Book();
        bookOne.setIsbn(UUID.randomUUID().toString());
        bookOne.setTitle("Book One");
        bookOne.setPublisher(publisherOne);
        //bookOne.setAuthors(authors);
        //bookOne.setPublisher(publisherOne);
        steve.getBooks().add(bookOne);

        publisherOne.getBooks().add(bookOne);

        authorRepository.save(steve);
        bookRepository.save(bookOne);

        logger.info("loaded in publisher: " + publisherOne.toString());
        logger.info("Loading in authors: " + steve.toString());
        logger.info("Loading in books:" + bookOne.toString());
    }
}
