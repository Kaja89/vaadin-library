package com.vaadin.exercises.front;

import com.vaadin.data.Binder;
import com.vaadin.exercises.library.Book;
import com.vaadin.exercises.library.BookService;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

@UIScope
public class BookForm extends FormLayout{

    private TextField title = new TextField("Title");
    private TextField author = new TextField("Author");
    private TextField year = new TextField("Year");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private BookService bookService = new BookService();
    private Book book;
    private MyUI myUI;

    private Binder <Book> bookBinder = new Binder<>(Book.class);

    public BookForm(MyUI myUI) {
        this.myUI = myUI;
        setSizeUndefined();
        settingsSaveButton();
        settingsDeleteButton();
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        addComponents(title, author, year, buttons);
        //bookBinder.bindInstanceFields(this);
    }

    public void settingsSaveButton(){
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.addClickListener(e -> bookBinder.bindInstanceFields(this));
        bookBinder.setBean(book);
    }

    public void settingsDeleteButton(){
        delete.addClickListener(e -> deleteBook());
    }

    public void setBook(Book book){
        this.book = book;
        bookBinder.setBean(book);
    }

    public void deleteBook(){
        bookService.delete(book);
        myUI.update();
    }

    public void saveBook(){
        bookService.save(book);
        myUI.update();
    }
}
