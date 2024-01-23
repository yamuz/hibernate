package com.example.jpademo;

import com.example.jpademo.dao.BookDao;
import com.example.jpademo.dao.BookDaoJpaImpl;
import com.example.jpademo.domain.Book;
import com.example.jpademo.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * created by Almaz on 12.01.2024
 */
@DataJpaTest
//initializer is used
@ComponentScan(basePackages = "com.example.jpademo.bootstrap")
@ActiveProfiles("local")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringDataJpaTest {
    @Autowired
    BookRepository bookRepository;


    @Test
    @Order(1)
    //@Commit
    void testJpaTestSplice() {

        long countBefore = bookRepository.count();
        System.out.println("**DataJpaTest** " + countBefore);

        assertThat(countBefore).isEqualTo(2);
        Book book = new Book("Alds", "dsf","ALmaz");
        bookRepository.save(book);

        long countAfter = bookRepository.count();
        System.out.println("**DataJpaTest after** " + countAfter);
        assertThat(countAfter).isEqualTo(countBefore + 1);
    }

}
