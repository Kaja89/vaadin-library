package com.vaadin.exercises.library;

import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Long> {
}
