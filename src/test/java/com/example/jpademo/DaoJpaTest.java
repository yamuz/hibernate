package com.example.jpademo;

import com.example.jpademo.dao.BookDao;
import com.example.jpademo.dao.BookDaoJpaImpl;
import com.example.jpademo.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * created by Almaz on 23.01.2024
 */
@ActiveProfiles("local")
@DataJpaTest
@Import({BookDaoJpaImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoJpaTest {
    @Autowired
    BookDao bookDaoJpa;

    @Test
    void testJpaDao() {
        List<Book> books =  bookDaoJpa.getBooks();

        System.out.println(String.format("bookdao jpa getbooks... booksSize=%d" ,books.size()));

        assertThat(books).isNotNull();
    }
}
