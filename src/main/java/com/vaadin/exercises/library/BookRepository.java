package com.vaadin.exercises.library;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    BookDao bookDao;

    public void delete(Book book){
        bookDao.delete(book);
    }

    public void save(Book book){
        bookDao.save(book);
    }
}
