package br.com.jonathan.machine.userinterface.handler;

import br.com.jonathan.machine.application.exceptions.ActionNotFoundException;
import br.com.jonathan.machine.application.exceptions.CommandNotFoundException;
import br.com.jonathan.machine.application.exceptions.InvalidPositionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(ActionNotFoundException.class)
    public ResponseEntity<Object> handle(ActionNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(CommandNotFoundException.class)
    public ResponseEntity<Object> handle(CommandNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(InvalidPositionException.class)
    public ResponseEntity<Object> handle(InvalidPositionException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
