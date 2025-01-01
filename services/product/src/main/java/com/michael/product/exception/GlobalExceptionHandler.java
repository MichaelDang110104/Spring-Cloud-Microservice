package com.michael.product.exception;
import com.michael.product.response.ResponseHandler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<Object> dataAccessException(BadCredentialsException badCredentialsException) {
//        return  ResponseHandler.responseBuilder(
//                badCredentialsException,HttpStatus.BAD_REQUEST,null
//        );
//    }


    public ResponseEntity<Object> entityNotFoundException(Exception exception) {
        return  ResponseHandler.responseBuilder(exception.getMessage(),HttpStatus.BAD_REQUEST,null);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolationException(DataIntegrityViolationException exception) {
        return  ResponseHandler.responseBuilder(exception.getMessage(),HttpStatus.BAD_REQUEST,null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return  ResponseHandler.responseBuilder(ex.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST,null);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        return  ResponseHandler.responseBuilder(ex.getMessage(),HttpStatus.BAD_REQUEST,null);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        System.out.println("Exception: " + ex.getMessage());
        return ResponseHandler.responseBuilder("Internal Server Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> noSuchElementException(NoSuchElementException exception) {
        System.out.println("Exception: " + exception.getMessage());
        return ResponseHandler.responseBuilder("No value present", HttpStatus.NOT_FOUND, null);
    }
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(DataAccessException exception) {
        System.out.println("Data access exception: " + exception.getMessage());
        return ResponseHandler.responseBuilder(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException exception) {
        System.out.println("Duplicate key exception: " + exception.getMessage());
        return ResponseHandler.responseBuilder(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
    @ExceptionHandler(MailException.class)
    public ResponseEntity<Object> handleMailException(MailException exception) {
        System.out.println("Mail exception: " + exception.getMessage());
        return ResponseHandler.responseBuilder(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
}