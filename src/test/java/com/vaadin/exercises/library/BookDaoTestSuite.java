package com.vaadin.exercises.library;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTestSuite {
    @Autowired
    BookDao bookDao;

    @Test
    public void testSaveBook(){
        //Given
        Book book = new Book("title", "author", 1878);
        //When
        bookDao.save(book);
        //Then
        long id = book.getId();
        Assert.assertEquals(id, bookDao.findOne(id).getId());
        //CleanUp
        bookDao.delete(id);
    }
}
