package com.example.jpademo.dao;

import com.example.jpademo.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * created by Almaz on 23.01.2024
 */
@Component
public class BookDaoJpaImpl implements BookDao {
    private final EntityManagerFactory emf;

    public BookDaoJpaImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Book> getBooks() {
        EntityManager em = createEntityManager();
        Query query = em.createQuery("SELECT b FROM  Book b" );
        return query.getResultList();
    }

    @Override
    public Book save(Book book) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();
        Book bookSaved = em.merge(book);
        return bookSaved;
    }

    @Override
    public Book findByTitleLike(String title) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("SELECT b FROM  Book b where b.title like :title", Book.class);
        query.setParameter("title", title + "%");
        Book book = query.getSingleResult();
        em.close();

        return book;
    }
    private EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
