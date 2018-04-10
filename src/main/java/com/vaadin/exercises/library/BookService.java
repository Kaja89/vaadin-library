package com.vaadin.exercises.library;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository bookRepository;

    public void save(Book book){
         bookRepository.save(book);
     }

     public void delete(Book book){
         bookRepository.delete(book);
     }
}
