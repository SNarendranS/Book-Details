package com.compositePrimaryKey.BookDetails.BooksDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.compositePrimaryKey.BookDetails.Entities.BookDetails;
import com.compositePrimaryKey.BookDetails.Entities.BookPrimaryKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookDetailsDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void saveBooks(BookDetails bd) {
		em.persist(bd);
	}
	
	public BookDetails findBook(BookPrimaryKey bpk) {
		return em.find(BookDetails.class, bpk);
	}
	
	public void updateBooks(BookDetails bd) {
		em.merge(bd);
	}
	
	public void deleteBookDetials(BookPrimaryKey bpk) {
		BookDetails bd=em.find(BookDetails.class, bpk);
		em.remove(bd);
	}
	
	public List<BookDetails> findByTitle(String title){
		Query query=em.createNamedQuery("findByTitle");
		query.setParameter(1, title);
		List<BookDetails> bookDetails=query.getResultList();
		return bookDetails;
	}
	
	public List<BookDetails> getBookByPrice(double price){
		Query query=em.createNativeQuery("select * from book_details where price>?",BookDetails.class);
		query.setParameter(1, price);
		List<BookDetails> bookDetails=query.getResultList();
		return bookDetails;
	}
}
