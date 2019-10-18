package io.github.tuanictu97;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAO {
	public static SessionFactory sessionfactory = null;
	public DAO() {
		sessionfactory = HibernateUtils.getSessionFactory();
	}
	public Integer addBook(Book book) {
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			bookId = (Integer) session.save(book);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}

		} finally {
			session.close();
		}
		return bookId;
	}
	public void updateBook(Book book) {
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			System.out.println("book update: name:"+book.getName());
			tx = session.beginTransaction();
			session.update(book);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}
	public void updateUser(Book book) {
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book bookUpdate = (Book) session.get(Book.class, book.getId());
			if(bookUpdate != null) {
				session.update(book);
				tx.commit();
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}
	public void deleteBook(int id) {
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = (Book) session.get(Book.class, id);
			if(book != null) {
				session.delete(book);
				tx.commit();
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}
	@SuppressWarnings("unchecked")
	public List<Book> getListBook(){
		List<Book> books = new ArrayList<Book>();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			books = (List<Book>) session.createSQLQuery("select * from books").addEntity(Book.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return books;
	}
	public Book getBookById(int id) {
		Book book = null;
		
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			book = session.get(Book.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return book;
	}
	public static void main(String[] args) {
		System.out.println("Name[0]: "+new DAO().getListBook().get(0).getName());
	}
	
}
