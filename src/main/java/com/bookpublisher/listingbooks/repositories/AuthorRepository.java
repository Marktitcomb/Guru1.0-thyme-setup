package com.bookpublisher.listingbooks.repositories;

import com.bookpublisher.listingbooks.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
