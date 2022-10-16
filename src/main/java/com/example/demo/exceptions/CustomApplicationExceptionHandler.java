package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// followed similar pattern from source: https://github.com/Java-Techie-jt/validation-exception-handling
@RestControllerAdvice
public class CustomApplicationExceptionHandler {

    /**
     * Set error message for the ExceptionHandler for @Valid annotations
     * @param ex exception with the error message
     * @return Map containing the errorMessage based on @Valid conditions
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    /**
     * Set error message for the ExceptionHandler for SuburbNotFoundException
     * @param ex exception with the error message
     * @return Map containing the errorMessage for when suburb is not found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SuburbNotFoundException.class)
    public Map<String, String> handleSuburbNotFoundException(SuburbNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    /**
     * Set error message for the ExceptionHandler for PostCodeNotFoundException
     * @param ex exception with the error message
     * @return Map containing the errorMessage for when the postcode is not found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostCodeNotFoundException.class)
    public Map<String, String> handlePostcodeNotFoundException(PostCodeNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    /**
     * Set error message for the ExceptionHandler for ResourceAlreadyExistsException
     * @param ex exception with the error message
     * @return Map containing the errorMessage for when the resource already exists
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public Map<String, String> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

}