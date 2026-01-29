package com.Prateek.rest.webservices.restful_web_services.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Prateek.rest.webservices.restful_web_services.user.UserNotFoundException;
 
// This is the main file that does error handling.
 
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(
            Exception ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<ErrorDetails>(errorDetails,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(
            UserNotFoundException ex, WebRequest request) {
    	
    		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
    		return new ResponseEntity<ErrorDetails>(errorDetails,
                    HttpStatus.NOT_FOUND);
    }
    // now if we enter any invalid url we get coustomised error Not that White Label Page
    // we get errorDetails object in return.
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    	
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getFieldErrors().toString(),request.getDescription(false));
//		ex.getFieldErrors() : is a array of all errors you got in your request ; you can iterate it to get specific error u want to display.
    	return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}

}	

/*
 * @ControllerAdvice : to make this class accessible to all controllers and test controllers .
 * 				-> it is specialization of @Component for the classes that declare @ExceptionHandler , @InitBinder or @ModelAttribute
 * 				methods to be shared across multiple controller classes.
 * 
 * @ExceptionHandler(Exception.class) : to define expection handler the method must be annotated with @ExceptionHandler
 * 					Exception.class means to handle all type of exceptions.
 *		-> annotation of handling exception in specific  handler class or method.
 */
