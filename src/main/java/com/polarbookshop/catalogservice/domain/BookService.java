/**
 * 
 */
package com.polarbookshop.catalogservice.domain;

import org.springframework.stereotype.Service;

import com.polarbookshop.catalogservice.exception.BookAlreadyExistsException;
import com.polarbookshop.catalogservice.exception.BookNotFoundException;

/**
 * @author Gbenga
 *
 */
@Service
public class BookService {

	private final BookRepository bookRepository;

	/**
	 * 
	 * @param bookRepository
	 */
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * 
	 * @return
	 */
	public Iterable<Book> viewBookList() {
		return bookRepository.findAll();
	}
	
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public Book viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }
	
	/**
	 * 
	 * @param book
	 * @return
	 */
	public Book addBookToCatalog(Book book) {
        if (bookRepository.existsByIsbn(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(BookMapper.createBook(book));
    }

	/**
	 * 
	 * @param isbn
	 */
    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }
    
    /**
     * 
     * @param isbn
     * @param book
     * @return
     */
    public Book editBookDetails(String isbn, Book book) {
      
		return bookRepository.findByIsbn(isbn)
				.map(existingBook -> {
					var bookToUpdate = BookMapper.editBook(existingBook, book);
					
					return bookRepository.save(bookToUpdate);
				})
				.orElseGet(() -> addBookToCatalog(book));
    }

}
