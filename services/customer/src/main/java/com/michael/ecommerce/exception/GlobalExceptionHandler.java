package com.michael.ecommerce.exception;
import com.michael.ecommerce.response.ResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
//
//    @ExceptionHandler(DataAccessException.class)
//    public ResponseEntity<Object> dataAccessException(UsernameNotFoundException usernameNotFoundException) {
//        return ResponseHandler.responseBuilder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .message(HttpStatus.INTERNAL_SERVER_ERROR.name())
//                .content("Lỗi trong quá trình lưu trữ dữ liệu!")
//                .build();
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<Object> dataAccessException(BadCredentialsException badCredentialsException) {
//        return  ResponseHandler.responseBuilder(
//                badCredentialsException,HttpStatus.BAD_REQUEST,null
//        );
//    }


    @ExceptionHandler(EntityNotFoundException.class)
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
}