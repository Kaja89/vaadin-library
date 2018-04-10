package com.vaadin.exercises.front;

import com.vaadin.annotations.Theme;
import com.vaadin.exercises.library.Book;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SpringUI
@Theme("valo")
public class MyUI extends UI{

    //@Autowired
    BookForm bookForm = new BookForm(this);
    HorizontalLayout mainLayout = new HorizontalLayout();
    Grid<Book> bookGrid = new Grid<>(Book.class);
    //temporary:
    List<Book> booksList = new ArrayList<>();
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        createBooks();
        setUpLayout();
        showBooks();
    }

    public void setUpLayout(){
        mainLayout.addComponents(bookForm);
        mainLayout.setSpacing(true);
        setContent(mainLayout);
        mainLayout.setMargin(true);
    }

    public void showBooks(){

        bookGrid.setItems(booksList);
        mainLayout.addComponent(bookGrid);
        mainLayout.setExpandRatio(bookGrid, 1);
    }

    public void createBooks(){
        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz",1978);
        Book book2 = new Book("Ogniem i mieczem", "Henryk Sienkiewicz", 2001);
        Book book3 = new Book("Potop", "Henryk Sienkiewicz", 1999);
        Book book4 = new Book("Pan Tadeusz", "Adam Mickiewicz", 2005);
        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);
    }

    public void update(){
        bookGrid.setItems(booksList);
    }
}
