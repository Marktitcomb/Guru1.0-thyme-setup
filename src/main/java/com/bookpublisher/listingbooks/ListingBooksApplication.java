package com.bookpublisher.listingbooks;

import com.bookpublisher.listingbooks.domain.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingBooksApplication {

	private static Logger logger = LoggerFactory.getLogger(ListingBooksApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ListingBooksApplication.class, args);

		Author author = new Author();
		author.setFirstName("Mark");
		author.setLastName("David");

		//two examples of logging here
		//straight to the console and using slf4j
		System.out.println(author.toString());

		//you can see that this line gets run after the boostrap loggers
	    logger.info(author.toString());

	}

}
