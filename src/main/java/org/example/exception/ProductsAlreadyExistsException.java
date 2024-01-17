package org.example.exception;

public class ProductsAlreadyExistsException extends RuntimeException {
    public ProductsAlreadyExistsException(String message) {
        super(message);
    }
}
