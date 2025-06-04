package mx.unam.aragon.ico.is.monhanapi.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HashMap<String, String>> restHandler(ConstraintViolationException exception){
        HashMap<String, String> answer = new HashMap<>();
        answer.put("message", exception.getLocalizedMessage());
        answer.put("timestam", LocalDateTime.now().toString());
        return new ResponseEntity<>(answer, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> restHandler(HttpMessageNotReadableException exception){
        HashMap<String, String> answer = new HashMap<>();
        answer.put("message", exception.getLocalizedMessage());
        answer.put("timestam", LocalDateTime.now().toString());
        answer.put("status", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
