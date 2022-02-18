package com.bookpublisher.listingbooks.repositories;

import com.bookpublisher.listingbooks.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
