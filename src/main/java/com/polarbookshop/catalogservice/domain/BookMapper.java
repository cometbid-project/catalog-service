/**
 * 
 */
package com.polarbookshop.catalogservice.domain;

import java.util.UUID;

/**
 * @author Gbenga
 *
 */
class BookMapper {

	static Book createBook(Book newBook) {		
		return Book.of(
				newBook.isbn(),
				newBook.title(),
				newBook.author(),
				newBook.price(),
				newBook.publisher());  
	}
	
	static Book editBook(Book existingBook, Book book) {
		return new Book(
				existingBook.id(),
				existingBook.isbn(),
				book.title(),
				book.author(),
				book.price(),
				book.publisher(),
				existingBook.createdDate(),
                existingBook.lastModifiedDate(),
				existingBook.version());
	}
}
