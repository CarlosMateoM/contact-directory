package com.software.elector.exception;

/**
 *
 * @author C.Mateo
 */
public class DatabaseAccessException extends RuntimeException {

    public DatabaseAccessException(String message) {
        super(message);
    }
    
    public DatabaseAccessException(String message, Throwable cause){
        super(message, cause);
    }
}
