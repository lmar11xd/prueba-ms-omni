package com.lmar.orquestadorservice.exception;

import com.lmar.orquestadorservice.model.dto.ErrorResponseTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponseTO> runtimeExceptionHandler(RuntimeException ex, WebRequest webRequest) {
        logger.error("Error", ex);
        ErrorResponseTO error = ErrorResponseTO.builder()
                .timestamp(LocalDateTime.now())
                .path(webRequest.getDescription(false))
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseTO> manejarGlobalException(Exception ex, WebRequest webRequest){
        logger.error("Error", ex);
        ErrorResponseTO error = ErrorResponseTO.builder()
                .timestamp(LocalDateTime.now())
                .path(webRequest.getDescription(false))
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseTO> manejarResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        logger.error("Error", ex);
        ErrorResponseTO error = ErrorResponseTO.builder()
                .timestamp(LocalDateTime.now())
                .path(webRequest.getDescription(false))
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        logger.error("Error", ex);
        Map<String,String> lstError = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            lstError.put(field, message);
        });

        ErrorResponseTO error = ErrorResponseTO.builder()
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Algunos campos no son válidos")
                .error(lstError)
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
