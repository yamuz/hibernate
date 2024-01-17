package com.example.jpademo;

import com.example.jpademo.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * created by Almaz on 13.01.2024
 */
@DataJpaTest//by default uses H2
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.example.jpademo.bootstrap"})//create bean Commandliner
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //dont replace mysql with h2
public class SqlIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void test() {
        long count  = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
