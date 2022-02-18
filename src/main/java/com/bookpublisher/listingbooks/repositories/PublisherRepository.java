package com.bookpublisher.listingbooks.repositories;

import com.bookpublisher.listingbooks.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
