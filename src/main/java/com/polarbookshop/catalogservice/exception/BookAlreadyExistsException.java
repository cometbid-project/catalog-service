/**
 * 
 */
package com.polarbookshop.catalogservice.exception;

/**
 * @author Gbenga
 *
 */
public class BookAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2938250591281400975L;

	public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN " + isbn + " already exists.");
    }

}
