package com.example.jpademo.dao;

import com.example.jpademo.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * created by Almaz on 23.01.2024
 */
@Component("dao_hibernate")
public class BookDaoHibernateImpl implements BookDao{
    private final SessionFactory sessionFactory;

    public BookDaoHibernateImpl(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public List<Book> getBooks(){
        return null;
    }


    public Book findByISBN(String isbn) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("from Book b where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book findByTitleLike(String title) {
        return null;
    }

    @Override
    public Book save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        Book saved = (Book) session.save(book);

        session.getTransaction().commit();
        return saved;
    }


}
